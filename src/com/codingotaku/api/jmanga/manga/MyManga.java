package com.codingotaku.api.jmanga.manga;

public class MyManga {
	private ChapterInfo last_chapter_read;
	private int last_page;
	private ChapterInfo latest_chapter;
	private MangaInfo manga;
	private ChapterInfo new_chapter_to_read;

	public ChapterInfo getLastChapterRead() {
		return last_chapter_read;
	}

	public int getLastPage() {
		return last_page;
	}

	public ChapterInfo getLatestChapter() {
		return latest_chapter;
	}

	public MangaInfo getManga() {
		return manga;
	}

	public ChapterInfo getNewChapterToRead() {
		return new_chapter_to_read;
	}

}
