package com.codingotaku.api.jmanga.manga;

import java.util.ArrayList;

public class Chapter {
	private Chapter() {};
	private ArrayList<String[]> images;
	private ArrayList<Page> pages;

	/**
	 * An {@link ArrayList} containing all pages on the {@link Chapter} object.
	 * */
	public ArrayList<Page> getPages() {
		if (pages != null) return pages;
		pages = new ArrayList<>();
		images.forEach(raw -> {
			Page page = new Page();
			page.chapterNumber = Integer.parseInt(raw[0]);
			page.imageUrl = raw[1];
			page.width = Integer.parseInt(raw[2]);
			page.height = Integer.parseInt(raw[3]);
			pages.add(page);
		});
		return pages;
	}
}
