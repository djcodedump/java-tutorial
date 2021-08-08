package com.deb.ex.json_jackson_examples;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bicycle{

	@JsonProperty("color")
	private String color;

	@JsonProperty("price")
	private double price;

	public String getColor(){
		return color;
	}

	public double getPrice(){
		return price;
	}
}