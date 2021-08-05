package com.deb.ex.json_examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws IOException {

        readJson();

    }

    private static void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(new File("json/test.json"), Response.class);

        response.getStore().getBook().forEach(x-> System.out.println(x.getTitle()));

        System.out.println("writing json string");

        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, response);

    }
}
