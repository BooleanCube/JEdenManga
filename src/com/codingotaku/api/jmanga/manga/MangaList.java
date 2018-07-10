package com.codingotaku.api.jmanga.manga;

import java.util.ArrayList;
import java.util.List;

public class MangaList {
	
	private int end = 0;
	private List<Manga> manga = new ArrayList<Manga>();
	private int page = 0;
	private int start = 0;
	private int total = 0;

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<Manga> getMangas() {
		return manga;
	}

	public void setManga(List<Manga> manga) {
		this.manga = manga;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
