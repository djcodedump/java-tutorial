package com.deb.ex.lombok_data_examples;

import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Customer customer = new Customer(1L, "deba",
                "tweep333", "deba@gmail.com");

        customer.setName("deep");
        System.out.println(customer);

        LoginData loginData = new LoginData("12345", "deba");
        System.out.println(loginData.authToken());
        System.out.println(loginData.userName());
        System.out.println(loginData);

    }
}
