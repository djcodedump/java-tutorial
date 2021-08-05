package com.deb.ex.json_examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        readJson();
    }

    private static void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Map<String,String> map = mapper.readValue(new File("json/test.json"),java.util.Map.class);
        Root root = mapper.readValue(new File("json/test.json"),Root.class);
        System.out.println(root);

        root.getStore().getBook().forEach(x -> System.out.println(x.getTitle()));
    }
}
