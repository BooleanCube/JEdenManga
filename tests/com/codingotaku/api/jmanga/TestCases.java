package com.codingotaku.api.jmanga;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;

import com.codingotaku.api.jmanga.manga.MangaList;
import com.codingotaku.api.jmanga.request.Status;

class TestCases {

	private String userName = "username"; // your user name
	private String password = "password"; // your password

	@Test
	void shouldRetrieveAllManga() {
		try {
			JEdenManga mangaEden = new JEdenManga();
			MangaList allManga = mangaEden.getAllManga();
			assertThat(allManga.getMangas().size(), IsNot.not(0));
		} catch (IOException w) {
			w.printStackTrace();
		}
	}

	@Test
	void shouldRetrieveFirst500Mangas() {
		try {
			JEdenManga mangaEden = new JEdenManga();
			MangaList allManga = mangaEden.getMangaListSplited(0);
			assertThat(allManga.getMangas().size(), Is.is(500));
			assertThat(allManga.getStart(), Is.is(0));
			assertThat(allManga.getEnd(), Is.is(500));
		} catch (IOException w) {
			w.printStackTrace();
		}
	}

	@Test
	void shouldRetrieve500To1000Mangas() {
		try {
			JEdenManga mangaEden = new JEdenManga();
			MangaList allManga = mangaEden.getMangaListSplited(2);
			assertThat(allManga.getMangas().size(), Is.is(500));
			assertThat(allManga.getStart(), Is.is(1000));
			assertThat(allManga.getEnd(), Is.is(1500));
		} catch (IOException w) {
			w.printStackTrace();
		}
	}
	
	@Test
	void verifyImage() {
		try {
			JEdenManga mangaEden = new JEdenManga();
			MangaList allManga = mangaEden.getMangaListSplitedRange(2, 30);
			assertThat(allManga.getMangas().size(), Is.is(30));
			assertThat(allManga.getStart(), Is.is(60));
			assertThat(allManga.getEnd(), Is.is(90));
		} catch (IOException w) {
			w.printStackTrace();
		}
	}

	@Test
	void shouldRetrieveUserMangaDetails() {
		JEdenManga mangaEden = new JEdenManga();
		Status status = mangaEden.login(userName, password.toCharArray());
		assertThat(status, Is.is(Status.OK));
		assertThat(mangaEden.myManga().size(), IsNot.not(0));
		mangaEden.logout();
	}

}
