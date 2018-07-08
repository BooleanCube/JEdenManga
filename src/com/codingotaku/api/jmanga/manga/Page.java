package com.codingotaku.api.jmanga.manga;

public class Page {
	private static String pre="https://cdn.mangaeden.com/mangasimg/%s";
	int chapterNumber;
	String imageUrl;
	int width;
	int height;
	public int getChapterNumber() {
		return chapterNumber;
	}
	public String getImageUrl() {
		return String.format(pre,imageUrl);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
