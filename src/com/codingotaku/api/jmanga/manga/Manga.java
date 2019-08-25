package com.codingotaku.api.jmanga.manga;

import java.io.IOException;

import com.codingotaku.api.jmanga.JEdenManga;
import com.codingotaku.api.jmanga.request.RequestHandler;

/**
 * Manga object containing title, categories and cover
 */
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

	/**
	 * @return other names for manga
	 */
	public String getAlias() {
		return a;
	}

	/**
	 * @return A String array containing categories of this manga
	 */
	public String[] getCategories() {
		return c;
	}

	/**
	 * @return Number of hits on manga
	 */
	public int getHits() {
		return h;
	}

	/**
	 * @return manga id
	 * @see JEdenManga#getMangaInfo(String)
	 */
	public String getID() {
		return i;
	}

	/**
	 * @return A string containing URL for cover image.
	 */
	public String getImage() {
		return String.format(pre, im);
	}

	/**
	 * @return last update of manga in integer
	 */
	public int getLastUpdate() {
		return ld;
	}

	/**
	 * @return Status of manga in integer
	 */
	public int getStatus() {
		return s;
	}

	/**
	 * @return manga title
	 */
	public String getTitle() {
		return t;
	}

	/**
	 * Returns all details about the manga including description and chapter info.
	 * 
	 * @return {@link MangaInfo}
	 * @see JEdenManga#getMangaInfo(Manga)
	 * @see JEdenManga#getMangaInfo(String)
	 */
	public MangaInfo getMangaInfo() throws IOException {
		return RequestHandler.instance().query(String.format("manga/%s", getID()), MangaInfo.class);
	}
}
