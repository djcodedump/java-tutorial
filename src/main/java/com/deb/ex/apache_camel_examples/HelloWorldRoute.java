package com.deb.ex.apache_camel_examples;

import org.apache.camel.builder.RouteBuilder;

public class HelloWorldRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        System.out.println("Hello World in Camel");
    }
}
