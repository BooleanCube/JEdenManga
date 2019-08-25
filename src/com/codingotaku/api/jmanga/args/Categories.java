package com.codingotaku.api.jmanga.args;

import com.google.gson.annotations.SerializedName;

/**
 * Genres supported by <a href="https://www.mangaeden.com">mangaeden</a>
 * */
public enum Categories {
	Action,
	Adult,
	Adventure,
	Comedy,
	Doujinshi,
	Drama,
	Ecchi,
	Fantasy,
	@SerializedName("Gender Bender")
	Gender_Bender,
	Harem,
	Historical,
	Horror,
	Josei,
	@SerializedName("Martial Arts")
	Martial_Arts,
	Mature,
	Mecha,
	Mystery,
	@SerializedName("One Shot")
	One_Shot,
	Psychological,
	Romance,
	@SerializedName("School Life")
	School_Life,
	@SerializedName("Sci-fi")
	Sci_fi,
	Seinen,
	Shoujo,
	Shounen,
	@SerializedName("Slice of Life")
	Slice_of_Life,
	Smut,
	Sports,
	Supernatural,
	Tragedy,
	Webtoons,
	Yaoi,
	Yuri;
}
