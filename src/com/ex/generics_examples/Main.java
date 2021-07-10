package com.ex.generics_examples;

import java.io.Serializable;
import java.sql.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1(){
        Container<Number> con = new Container<>();

        con.demo(new ArrayList<Integer>());

        con.demo2(new ArrayList<Serializable>());

    }

    static void test2(){
        List<Integer> list1 = Arrays.asList(123,321,542);

        Collections.sort(list1, (o1, o2) -> (o1%10 - o2%10));

        list1.forEach(System.out::println);

        List<Integer> list2 = new ArrayList<>()
        {{
            add(121);
            add(211);
            add(345);
        }};

        list2.forEach(x -> System.out.println(x));
    }
}
