package com.deb.ex.json_examples;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
public class Root{
     private Store store;
}

@Data
class Store{
    private List<Book> book;
    private Bicycle bicycle;
}

@Data
class Book{
    private String category;
    private String author;
    private String title;
    private double price;
    private String isbn;
}

@Data
class Bicycle{
    private String color;
    private double price;
}
