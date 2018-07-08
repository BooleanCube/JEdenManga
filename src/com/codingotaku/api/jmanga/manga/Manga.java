package com.codingotaku.api.jmanga.manga;

import java.io.IOException;

import com.codingotaku.api.jmanga.request.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Manga {
	private static Gson gson = new Gson();
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
		JsonObject response = RequestHandler.instance().query( String.format("manga/%s", getID()));
		
		return gson.fromJson(response, MangaInfo.class);
	}
}
