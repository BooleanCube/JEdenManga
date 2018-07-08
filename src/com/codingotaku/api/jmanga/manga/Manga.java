package com.codingotaku.api.jmanga.manga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Manga {
	private static String apiUrl = "https://www.mangaeden.com/api/";

	private String a;
	private String[] c;
	private int h;
	private String i;
	private String im;
	private int ld;
	private int s;
	private String t;

	public String getAlias() {
		return a;
	}

	public String[] getCategories() {
		return c;
	}

	public int getHits() {
		return h;
	}

	public String getID() {
		return i;
	}

	public String getImage() {
		return im;
	}

	public int getLastUpdate() {
		return ld;
	}

	public int getStatus() {
		return s;
	}

	public String getTitle() {
		return t;
	}

	public MangaInfo getMangaInfo() throws IOException {
		JsonObject response = sendRequest(apiUrl, String.format("manga/%s", getID()));
		Gson gson = new Gson();
		return gson.fromJson(response, MangaInfo.class);
	}

	private JsonObject sendRequest(String address, String param) throws IOException {
		String url = address + param;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
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

}
