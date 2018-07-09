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

	public static void main(String[] args) {
		try {
			JEdenManga mangaEden=new JEdenManga();
			String title = mangaEden.getAllManga().getMangas().get(5).getTitle();
			System.out.println(title);
			Status status = mangaEden.login("mobiuslooop", "RKaihkuyloA510".toCharArray());
			if(status==Status.OK) {
				mangaEden.myManga().forEach(manga->{
					System.out.println(manga.getManga().getTitle());
				});
			}
			mangaEden.logout();
			
		} catch (IOException w) {
			w.printStackTrace();
		}
	}

	public JEdenManga() {
		handler = RequestHandler.instance();
	}

	public void setLanguage(Language l) {
		lang = l.ordinal();
	}

	public MangaList getAllManga() throws IOException {
		return handler.query(String.format("list/%d/?p=0", lang), MangaList.class);
	}

	public MangaList getMangaListSplited(int page) throws IOException {
		return handler.query(String.format("list/%d/?p=%d", lang, page), MangaList.class);
	}

	public MangaList getMangaListSplitedRange(int page, int size) throws IOException {
		return handler.query(String.format("list/%d/?p=%d&l=%d", lang, page, size), MangaList.class);
	}

	public MangaInfo getMangaInfo(Manga manga) throws IOException {
		return getMangaInfo(manga.getID());
	}

	public MangaInfo getMangaInfo(String mangaId) throws IOException {
		return handler.query(String.format("manga/%s", mangaId), MangaInfo.class);
	}

	public ArrayList<Page> getChapterPages(ChapterInfo chapter) throws IOException {
		return getChapterPages(chapter.getId());
	}

	public ArrayList<Page> getChapterPages(String chapterId) throws IOException {
		return handler.query(String.format("chapter/%s", chapterId), Chapter.class).getPages();
	}

	public Status login(String userName, char[] password) {
		return handler.login(userName, password);
	}

	public Status logout() {
		return handler.logout();
	}

	public List<MyManga> myManga() {
		return handler.myManga();
	}

}