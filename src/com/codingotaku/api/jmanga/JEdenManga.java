package com.codingotaku.api.jmanga;

import java.io.IOException;
import java.util.ArrayList;
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

public class JEdenManga {
	private final RequestHandler handler;
	private int lang = Language.English.ordinal();

	/**
	 * Initializes a new JEdenManga object. uses the same web session if connection
	 * is already made.
	 */
	public JEdenManga() {
		handler = RequestHandler.instance();
	}

	/**
	 * Set the {@link Language} for manga
	 * 
	 * @param language Supports English and Italian
	 */
	public void setLanguage(Language language) {
		lang = language.ordinal();
	}

	/**
	 * Returns a complete list of manga, to avoid server load please try to use this
	 * only once or twice in a day.
	 * 
	 * @return {@link MangaList}
	 */
	public MangaList getAllManga() throws IOException {
		return handler.query(String.format("list/%d/", lang), MangaList.class);
	}

	/**
	 * Similar to {@link JEdenManga#getAllManga()}, but returns a list of manga
	 * containing 500 entries(from manga X500 to (X+1)500, where X is the page
	 * argument) pagination is provided to maintain the list.
	 * 
	 * @param page page number in integer
	 * @return {@link MangaList}
	 */
	public MangaList getMangaListSplited(int page) throws IOException {
		return handler.query(String.format("list/%d/?p=%d", lang, page), MangaList.class);
	}

	/**
	 * Similar to {@link JEdenManga#getMangaListSplited(int)}, but returns only Y
	 * manga’s informations (from manga XY to (X+1)Y) [25 &lt; Y &lt; 1500]<br>
	 * If X is 0 and Y is 30, this will return first 30 list, if x is 1 and y is 30
	 * this will return mangas 30 to 60 if x is 2 and y is 50 it will return mangas
	 * from the range 100 to 150 and so on x is the page value and y is the number
	 * of manga in the page.
	 * 
	 * @param page page number in integer
	 * @param size size of each page in integer
	 * @return {@link MangaList}
	 */
	public MangaList getMangaListSplitedRange(int page, int size) throws IOException {
		return handler.query(String.format("list/%d/?p=%d&l=%d", lang, page, size), MangaList.class);
	}

	/**
	 * Returns all details about the provided {@link Manga} including description
	 * and chapter info.
	 * 
	 * @param manga {@link Manga} object got from {@link MangaList#getMangas()}
	 * @return {@link MangaInfo}
	 */
	public MangaInfo getMangaInfo(Manga manga) throws IOException {
		return getMangaInfo(manga.getID());
	}

	/**
	 * Similar to {@link JEdenManga#getMangaInfo(Manga)}, Returns all details about
	 * the provided mangaId got from {@link Manga#getID()} including description and
	 * chapter info.
	 * 
	 * @param mangaId a string mangaId got from {@link Manga#getID()}
	 * @return {@link MangaInfo}
	 */
	public MangaInfo getMangaInfo(String mangaId) throws IOException {
		return handler.query(String.format("manga/%s", mangaId), MangaInfo.class);
	}

	/**
	 * Returns an {@link ArrayList} containing chapter {@link Page}s from given
	 * {@link ChapterInfo}.
	 * 
	 * @param chapter {@link ChapterInfo}
	 * 
	 */
	public ArrayList<Page> getChapterPages(ChapterInfo chapter) throws IOException {
		return getChapterPages(chapter.getId());
	}

	/**
	 * Similar to {@link JEdenManga#getChapterPages(ChapterInfo)}, returns an
	 * {@link ArrayList} containing chapter {@link Page}s from given chapterId, you can get
	 * it from {@link ChapterInfo#getId()}.
	 * 
	 * @param chapterId
	 * 
	 * @return List of Pages from chapter.
	 */
	public ArrayList<Page> getChapterPages(String chapterId) throws IOException {
		return handler.query(String.format("chapter/%s", chapterId), Chapter.class).getPages();
	}

	/**
	 * Login user with <a href="https://www.mangaeden.com">mangaeden</a> web site, the session is stored in a cookie but it
	 * will be cleared as soon as the application completely terminates. saving cookie is not supported yet.
	 * 
	 * @param userName user name of user in string
	 * @param password password of user in char array
	 * 
	 * @return {@link Status} {@link Status#OK} if request succeeds and {@link Status#ERROR} when request fail.
	 */
	public Status login(String userName, char[] password) {
		return handler.login(userName, password);
	}

	/**
	 * To Logout user from <a href="https://www.mangaeden.com">mangaeden</a> web site.
	 * 	 * 
	 * @return {@link Status} {@link Status#OK} if request succeeds and {@link Status#ERROR} when request fail.
	 */
	public Status logout() {
		return handler.logout();
	}

	/**
	 * Returns a List of {@link MyManga} if the user is logged in, throws AccountAccessException if not.
	 * */
	public List<MyManga> myManga() {
		return handler.myManga();
	}

}