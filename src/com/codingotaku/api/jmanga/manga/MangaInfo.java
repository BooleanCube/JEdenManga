package com.codingotaku.api.jmanga.manga;

import java.util.ArrayList;
import java.util.List;

import com.codingotaku.api.jmanga.JEdenManga;
import com.codingotaku.api.jmanga.args.Categories;
import com.codingotaku.api.jmanga.args.Language;
import com.google.gson.annotations.SerializedName;

/**
 * Provides details about manga including aliases description chapters etc..
 */
public class MangaInfo {
	private static String pre = "https://cdn.mangaeden.com/mangasimg/%s";
	String[] aka;
	@SerializedName("aka-alias")
	String[] aka_alias;
	String alias;
	String artist;
	String[] artist_kw;
	String author;
	String[] author_kw;
	boolean autoManga;
	boolean baka;
	List<Categories> categories;
	ArrayList<String[]> chapters;
	ArrayList<ChapterInfo> chaptersConverted = new ArrayList<>();
	int chapters_len;
	long created;
	String description;
	int hits;
	String image;
	String imageURL;
	Language language;
	long last_chapter_date;
	int released;
	String startsWith;
	int status;
	String title;
	String[] title_kw;
	int type;
	boolean updatedKeywords;
	String url;

	/**
	 * @return String array of other names that this manga is also known as.
	 */
	public String[] getAka() {
		return aka;
	}

	/**
	 * @return String array of list of aka aliases.
	 */
	public String[] getAkaAlias() {
		return aka_alias;
	}

	/**
	 * @return String array of list of aka aliases.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return artist name.
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @return string array containing artist names in other languages.
	 */
	public String[] getArtistKw() {
		return artist_kw;
	}

	/**
	 * @return auther name
	 */
	public String getAuthor() {
		return author;
	}

	/** @return Auther name in other languages */
	public String[] getAuthorKw() {
		return author_kw;
	}

	/**
	 * @return is auto manga
	 */
	public boolean isAutoManga() {
		return autoManga;
	}

	/**
	 * @return you are a baka
	 */
	public boolean isBaka() {
		return baka;
	}

	/**
	 * @return A {@link List} containing {@link Categories}
	 */
	public List<Categories> getCategories() {
		return categories;
	}

	/**
	 * @return {@link ArrayList} containing {@link ChapterInfo}
	 * @see JEdenManga#getChapterPages(ChapterInfo)
	 */
	public ArrayList<ChapterInfo> getChapters() {
		if (chaptersConverted.isEmpty())
			chapters.forEach(this::addChapter);
		return chaptersConverted;
	}

	private void addChapter(String[] tmp) {
		ChapterInfo chapter = new ChapterInfo();
		chapter.number = Integer.parseInt(tmp[0]);
		chapter.date = tmp[1];
		chapter.title = tmp[2];
		chapter.id = tmp[3];
		chaptersConverted.add(chapter);
	}

	/**
	 * @return chapter length
	 */
	public int getChapters_len() {
		return chapters_len;
	}

	/**
	 * @return manga created date in long
	 */
	public long getCreated() {
		return created;
	}

	/**
	 * @return Manga description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return number of manga hits
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @return A String containing Manga cover image url
	 */
	public String getImage() {
		return String.format(pre, image);
	}

	/**
	 * @return Manga Image URL in string, use if {@link MangaInfo#getImage()} is not
	 *         working
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @return Manga Language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @return Last chapter update date in long
	 */
	public long getLastChapterDate() {
		return last_chapter_date;
	}

	/**
	 * @return Manga released date
	 */
	public int getReleased() {
		return released;
	}

	/**
	 * @return manga starts with
	 */
	public String getStartsWith() {
		return startsWith;
	}

	/**
	 * @return manga status in integer format
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @return Manga atitle
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return Manga title in other languages
	 */
	public String[] getTitleKw() {
		return title_kw;
	}

	/**
	 * @return Manga type in integer
	 */
	public int getType() {
		return type;
	}

	/**
	 * @return is manga keywords updated or not
	 */
	public boolean isUpdatedKeywords() {
		return updatedKeywords;
	}

	/**
	 * @return Manga URL in string
	 */
	public String getUrl() {
		return url;
	}
}
