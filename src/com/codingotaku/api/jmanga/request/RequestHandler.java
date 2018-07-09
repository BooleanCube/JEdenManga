package com.codingotaku.api.jmanga.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.codingotaku.api.jmanga.exception.AccountAccessException;
import com.codingotaku.api.jmanga.manga.MyManga;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class RequestHandler {
	private static final String apiUrl = "https://www.mangaeden.com/api/";
	private static final String accUrl = "https://www.mangaeden.com/ajax/";
	private static final String profUrl = "https://www.mangaeden.com/api/mymanga/";
	private static RequestHandler instance;
	private final HttpClient client;
	private final Gson gson;

	public <T> T readJsonStream(InputStream in, Class<T> type) throws IOException {
		final JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		final T message = gson.fromJson(reader, type);
		reader.close();
		return message;
	}

	private RequestHandler() {
		gson = new Gson();
		HttpClientBuilder builder = HttpClientBuilder.create();
		client = builder.build();
	}

	public Status login(String userName, char[] password) {
		String url = String.format(accUrl + "login?username=%s&password=%s", userName, String.valueOf(password));
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse httpResponse = client.execute(httpget);

			BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			int len;
			StringBuffer response = new StringBuffer();
			char[] buffer = new char[8192];
			while ((len = in.read(buffer)) != -1) {
				response.append(buffer, 0, len);
			}
			in.close();
			return response.toString().equals("OK") ? Status.OK : Status.ERROR;
		} catch (IOException e) {
			return Status.ERROR;
		}
	}

	public Status logout() {
		String url = accUrl + "logout/";
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse httpResponse = client.execute(httpget);
			BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			int len;
			StringBuffer response = new StringBuffer();
			char[] buffer = new char[8192];
			while ((len = in.read(buffer)) != -1) {
				response.append(buffer, 0, len);
			}
			in.close();
			return response.toString().equals("OK") ? Status.OK : Status.ERROR;
		} catch (IOException e) {
			return Status.ERROR;
		}
	}

	public List<MyManga> myManga() {
		try {
			HttpGet httpget = new HttpGet(profUrl);
			HttpResponse httpResponse = client.execute(httpget);
			final JsonReader reader = new JsonReader(
					new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
			final List<MyManga> mangas = new ArrayList<>();
			reader.beginObject();
			reader.nextName();
			reader.beginArray();
			while (reader.hasNext()) {
				mangas.add(gson.fromJson(reader, MyManga.class));
			}
			reader.endArray();
			reader.endObject();
			return mangas;
		} catch (IOException | JsonSyntaxException e) {
			e.printStackTrace();
			throw new AccountAccessException();
		}
	}

	public <T> T query(String param, Class<T> type) throws IOException {
		final String url = apiUrl + param;
		final HttpGet httpget = new HttpGet(url);
		HttpResponse httpResponse = client.execute(httpget);
		return readJsonStream(httpResponse.getEntity().getContent(), type);
	}

	public static RequestHandler instance() {
		if (instance == null) instance = new RequestHandler();
		return instance;
	}
}
