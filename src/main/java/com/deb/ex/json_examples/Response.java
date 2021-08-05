package com.deb.ex.json_examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class Response{

	@JsonProperty("store")
	private Store store;

	public Store getStore(){
		return store;
	}
}