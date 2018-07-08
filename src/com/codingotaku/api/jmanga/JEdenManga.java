package com.codingotaku.api.jmanga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codingotaku.api.jmanga.args.Language;
import com.codingotaku.api.jmanga.manga.Chapter;
import com.codingotaku.api.jmanga.manga.ChapterInfo;
import com.codingotaku.api.jmanga.manga.Manga;
import com.codingotaku.api.jmanga.manga.MangaInfo;
import com.codingotaku.api.jmanga.manga.MangaList;
import com.codingotaku.api.jmanga.manga.MyManga;
import com.codingotaku.api.jmanga.manga.Page;
import com.codingotaku.api.jmanga.request.RequestHandler;
import com.codingotaku.api.jmanga.request.Status;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JEdenManga {
	private final RequestHandler handler;
	private final Gson gson;
	private int lang = Language.English.ordinal();
	
	public JEdenManga() {
		handler = RequestHandler.instance();
		gson = new Gson();
	}

	public void setLanguage(Language l) {
		lang = l.ordinal();
	}

	public MangaList getAllManga() throws IOException {

		JsonObject response = handler.query(String.format("list/%d/?p=0", lang));
		return gson.fromJson(response, MangaList.class);
	}

	public MangaList getMangaListSplited(int page) throws IOException {
			JsonObject response = handler.query(String.format("list/%d/?p=%d", lang, page));
			return gson.fromJson(response, MangaList.class);
	}

	public MangaList getMangaListSplitedRange(int page, int size) throws IOException {
		JsonObject response = handler.query(String.format("list/%d/?p=%d&l=%d", lang, page, size));
		return gson.fromJson(response, MangaList.class);

	}

	public MangaInfo getMangaInfo(Manga manga) throws IOException {
		return getMangaInfo(manga.getID());
	}

	public MangaInfo getMangaInfo(String mangaId) throws IOException {
		JsonObject response = handler.query(String.format("manga/%s", mangaId));
		return gson.fromJson(response, MangaInfo.class);

	}

	public ArrayList<Page> getChapterPages(ChapterInfo chapter) throws IOException {
		return getChapterPages(chapter.getId());
	}

	public ArrayList<Page> getChapterPages(String chapterId) throws IOException {
		JsonObject response = handler.query(String.format("chapter/%s", chapterId));

		return gson.fromJson(response, Chapter.class).getPages();
	}

	public Status login(String userName, char[] password) {
		return handler.login(userName, password);
	}

	public Status logout() {
		return handler.logout();
	}

	public List<MyManga> myManga() {
		JsonObject myManga = handler.myManga();
		MyManga[] response = gson.fromJson(myManga.getAsJsonArray("mymanga"), MyManga[].class);
		return Arrays.asList(response);
	}

}