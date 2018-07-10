package com.codingotaku.api.jmanga.manga;

import java.util.ArrayList;
import java.util.List;

import com.codingotaku.api.jmanga.args.Categories;
import com.codingotaku.api.jmanga.args.Language;
import com.google.gson.annotations.SerializedName;

public class MangaInfo {
	private static String pre="https://cdn.mangaeden.com/mangasimg/%s";
	String[] aka;
	@SerializedName("aka-alias") String[] aka_alias;
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

	public String[] getAka() {
		return aka;
	}

	public String[] getAkaAlias() {
		return aka_alias;
	}

	public String getAlias() {
		return alias;
	}

	public String getArtist() {
		return artist;
	}

	public String[] getArtistKw() {
		return artist_kw;
	}

	public String getAuthor() {
		return author;
	}

	public String[] getAuthorKw() {
		return author_kw;
	}

	public boolean isAutoManga() {
		return autoManga;
	}

	public boolean isBaka() {
		return baka;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public ArrayList<ChapterInfo> getChapters() {
		if (chaptersConverted.isEmpty()) chapters.forEach(this::addChapter);
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

	public int getChapters_len() {
		return chapters_len;
	}

	public long getCreated() {
		return created;
	}

	public String getDescription() {
		return description;
	}

	public int getHits() {
		return hits;
	}

	public String getImage() {
		return String.format(pre, image);
	}

	public String getImageURL() {
		return String.format(pre,imageURL);
	}

	public Language getLanguage() {
		return language;
	}

	public long getLastChapterDate() {
		return last_chapter_date;
	}

	public int getReleased() {
		return released;
	}

	public String getStartsWith() {
		return startsWith;
	}

	public int getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String[] getTitleKw() {
		return title_kw;
	}

	public int getType() {
		return type;
	}

	public boolean isUpdatedKeywords() {
		return updatedKeywords;
	}

	public String getUrl() {
		return url;
	}

}
