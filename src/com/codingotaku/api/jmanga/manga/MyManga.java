package com.codingotaku.api.jmanga.manga;

public class MyManga {
	private String last_chapter_read;
	private int last_page;
	private Chapter latest_chapter;
	private MangaInfo manga;
	private String new_chapter_to_read;

	public String getLastChapterRead() {
		return last_chapter_read;
	}

	public int getLastPage() {
		return last_page;
	}

	public Chapter getLatestChapter() {
		return latest_chapter;
	}

	public MangaInfo getManga() {
		return manga;
	}

	public String getNewChapterToRead() {
		return new_chapter_to_read;
	}

}
