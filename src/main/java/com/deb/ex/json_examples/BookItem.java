package com.deb.ex.json_examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class BookItem{

	@JsonProperty("author")
	private String author;

	@JsonProperty("price")
	private double price;

	@JsonProperty("isbn")
	private String isbn;

	@JsonProperty("category")
	private String category;

	@JsonProperty("title")
	private String title;

	public String getAuthor(){
		return author;
	}

	public double getPrice(){
		return price;
	}

	public String getIsbn(){
		return isbn;
	}

	public String getCategory(){
		return category;
	}

	public String getTitle(){
		return title;
	}
}