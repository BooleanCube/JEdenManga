package com.codingotaku.api.jmanga.manga;

import java.util.ArrayList;
import java.util.List;

/**
 * Paginated List of {@link Manga}
 */
public class MangaList {

	private int end = 0;
	private List<Manga> manga = new ArrayList<Manga>();
	private int page = 0;
	private int start = 0;
	private int total = 0;

	/**
	 * @return Index of last manga in list
	 * @see MangaList#getMangas()
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end Set index of last manga in list
	 * @see MangaList#getMangas()
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return List of {@link Manga}
	 */
	public List<Manga> getMangas() {
		return manga;
	}

	/**
	 * @param manga {@link List} of {@link Manga}
	 */
	public void setManga(List<Manga> manga) {
		this.manga = manga;
	}

	/**
	 * @return get current page (during pagination)
	 **/
	public int getPage() {
		return page;
	}

	/**
	 * 
	 * @param page set page number (for pagination)
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return Index of first manga in list
	 * @see MangaList#getMangas()
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start Set index of first manga in list
	 * @see MangaList#getMangas()
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return Total number of mangas in page
	 * @see MangaList#getMangas()
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total Set total number of mangas in page
	 * @see MangaList#getMangas()
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
