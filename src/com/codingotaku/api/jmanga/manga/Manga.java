package com.codingotaku.api.jmanga.manga;

import java.io.IOException;

import com.codingotaku.api.jmanga.request.RequestHandler;

public class Manga {
	private static String pre = "https://cdn.mangaeden.com/mangasimg/%s";
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
		return String.format(pre, im);
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
		return RequestHandler.instance().query(String.format("manga/%s", getID()), MangaInfo.class);
	}
}
