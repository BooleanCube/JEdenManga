package com.codingotaku.api.jmanga.manga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ChapterInfo {
	private static String apiUrl = "https://www.mangaeden.com/api/";
	
	int number;
	String date;
	String title;
	String id;

	public int getChapterNumber() {
		return number;
	}

	public String getChapterDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Page> getPages() throws IOException {
		JsonObject response = sendRequest(apiUrl, String.format("chapter/%s", getId()));
		Gson gson = new Gson();
		return gson.fromJson(response, Chapter.class).getPages();
	}
	private JsonObject sendRequest(String address, String param) throws IOException {
		String url = address + param;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
