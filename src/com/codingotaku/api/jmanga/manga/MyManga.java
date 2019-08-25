package com.codingotaku.api.jmanga.manga;

import com.codingotaku.api.jmanga.JEdenManga;

/**
 * Users favorite manga
 * 
 * @see JEdenManga#myManga()
 */
public class MyManga {
	private ChapterInfo last_chapter_read;
	private int last_page;
	private ChapterInfo latest_chapter;
	private MangaInfo manga;
	private ChapterInfo new_chapter_to_read;

	/**
	 * @return {@link ChapterInfo} of last chapter read
	 */
	public ChapterInfo getLastChapterRead() {
		return last_chapter_read;
	}

	/**
	 * @return Last Chapter read index
	 */
	public int getLastPage() {
		return last_page;
	}

	/**
	 * @return {@link ChapterInfo} of latest chapter.
	 */
	public ChapterInfo getLatestChapter() {
		return latest_chapter;
	}

	/**
	 * @return {@link MangaInfo}
	 */
	public MangaInfo getManga() {
		return manga;
	}

	/**
	 * 
	 * @return {@link ChapterInfo} if new Chapter exist.
	 */
	public ChapterInfo getNewChapterToRead() {
		return new_chapter_to_read;
	}

}
