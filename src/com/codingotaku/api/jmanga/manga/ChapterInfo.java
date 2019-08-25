package com.codingotaku.api.jmanga.manga;

import java.io.IOException;
import java.util.ArrayList;

import com.codingotaku.api.jmanga.JEdenManga;
import com.codingotaku.api.jmanga.request.RequestHandler;

/**
 * Contains information about the chapter like title, created date, number, and id.
 * @see JEdenManga#getChapterPages(ChapterInfo)
 * */
public class ChapterInfo {
	int number;
	String date;
	String title;
	String id;

	/**
	 * @return The chapter number
	 */
	public int getChapterNumber() {
		return number;
	}

	/**
	 * @return The chapter created date in string format
	 */
	public String getChapterDate() {
		return date;
	}

	/**
	 * @return The chapter title in string format
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return The chapter id in string format
	 * @see JEdenManga#getChapterPages(String)
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns a list of pages from given chapter
	 * @return An {@link ArrayList} containing list of {@link Page}s
	 * 
	 * @see JEdenManga#getChapterPages(ChapterInfo)
	 * @see JEdenManga#getChapterPages(String)
	 * */
	public ArrayList<Page> getPages() throws IOException {
		return RequestHandler.instance().query(String.format("chapter/%s", getId()), Chapter.class).getPages();
	}
}
