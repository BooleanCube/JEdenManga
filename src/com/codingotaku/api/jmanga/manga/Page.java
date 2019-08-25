package com.codingotaku.api.jmanga.manga;

public class Page {
	private static String pre = "https://cdn.mangaeden.com/mangasimg/%s";
	int chapterNumber;
	String imageUrl;
	int width;
	int height;

	/**
	 * @return chapter number belonging to current page
	 */
	public int getChapterNumber() {
		return chapterNumber;
	}

	/**
	 * @return manga chapter page image
	 */
	public String getImageUrl() {
		return String.format(pre, imageUrl);
	}

	/**
	 * @return page width in integer
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return page height in integer
	 */
	public int getHeight() {
		return height;
	}
}
