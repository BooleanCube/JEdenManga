package com.codingotaku.api.jmanga.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.codingotaku.api.jmanga.exception.AccountAccessException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class RequestHandler {
	private static String apiUrl = "https://www.mangaeden.com/api/";
	private static String accUrl = "https://www.mangaeden.com/ajax/";
	private static String profUrl = "https://www.mangaeden.com/api/mymanga/";
	private static RequestHandler instance = null;
	HttpClient client;

	private RequestHandler() {
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

	public JsonObject myManga() {
		try {
			HttpGet httpget = new HttpGet(profUrl);
			HttpResponse httpResponse = client.execute(httpget);
			BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			int len;
			StringBuffer response = new StringBuffer();
			char[] buffer = new char[8192];
			while ((len = in.read(buffer)) != -1) {
				response.append(buffer, 0, len);
			}
			in.close();
			// Read JSON response and print
			JsonParser parser = new JsonParser();

			return parser.parse(response.toString()).getAsJsonObject();
		} catch (IOException | JsonSyntaxException e) {
			throw new AccountAccessException();
		}
	}

	public JsonObject query(String param) throws IOException {
		String url = apiUrl + param;
		HttpGet httpget = new HttpGet(url);
		HttpResponse httpResponse = client.execute(httpget);
		BufferedReader in = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
		int len;
		StringBuffer response = new StringBuffer();
		char[] buffer = new char[8192];
		while ((len = in.read(buffer)) != -1) {
			response.append(buffer, 0, len);
		}
		in.close();
		// Read JSON response and print
		JsonParser parser = new JsonParser();
		JsonObject myResponse = parser.parse(response.toString()).getAsJsonObject();
		return myResponse;
	}

	public static RequestHandler create() {
		if (instance == null) instance = new RequestHandler();
		return instance;
	}
}
