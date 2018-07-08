package com.codingotaku.api.jmanga.manga;

import java.io.IOException;
import java.util.ArrayList;

import com.codingotaku.api.jmanga.request.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ChapterInfo {
	private static Gson gson = new Gson();
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
		JsonObject response = RequestHandler.instance().query(String.format("chapter/%s", getId()));
		return gson.fromJson(response, Chapter.class).getPages();
	}
}
