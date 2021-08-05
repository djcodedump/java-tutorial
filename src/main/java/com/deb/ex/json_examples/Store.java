package com.deb.ex.json_examples;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Store{

	@JsonProperty("bicycle")
	private Bicycle bicycle;

	@JsonProperty("book")
	private List<BookItem> book;

	public Bicycle getBicycle(){
		return bicycle;
	}

	public List<BookItem> getBook(){
		return book;
	}
}