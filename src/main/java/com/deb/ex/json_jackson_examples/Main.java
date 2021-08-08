package com.deb.ex.json_jackson_examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //readJson();
        //readJsonAsNodeTree();
        fetchByJsonPath();
    }

    private static void fetchByJsonPath() throws IOException {

        File file = new File("json/test.json");
        List<String> authors = JsonPath.read(file, "$.store.book[*].author");

        //List<String> authors = JsonPath.read(file, "$.store.book[?(@.title == \"Sword of Honour\")]");

        authors.forEach(System.out::println);
    }

    private static void readJson() throws IOException {

        File file = new File("json/test.json");

        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(file, Response.class);

        response.getStore().getBook().forEach(x-> System.out.println(x.getTitle()));

        System.out.println("writing json string");
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, response);
    }

    public static void readJsonAsNodeTree() throws IOException {

        File file = new File("json/test.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(file);

        System.out.println("***** writing rootNode *******");

        //System.out.println(rootNode.toPrettyString());

        JsonNode bookNode = rootNode.path("store").path("book");
        System.out.println(bookNode.toPrettyString());

        Iterator<JsonNode> itr = bookNode.elements();

        while (itr.hasNext()){
            JsonNode book = itr.next();
            System.out.println(book);
        }
    }
}
