package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsApiExamples {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    static void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        list.forEach(c);

        //using Lambda expression
        Consumer<Integer> c1 = i -> System.out.println(i);
        list.forEach(c1);

        list.forEach(i -> System.out.println(i));
        list.forEach(i -> doubleit(i));

        //using method reference (call by method)
        list.forEach(System.out::println);
        list.forEach(StreamsApiExamples::doubleit);

    }
    static void doubleit(int i){
        System.out.println(i * 2);
    }

    static void test2(){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            list.add(Integer.valueOf(i));
        }

        //list.stream().forEach(System.out::println);

        list.stream().filter(i -> {
            System.out.println("hi");
            return true;
        }).findFirst();

        //list.stream().filter(i->(i%2)==0).forEach(System.out::println);

    }
}
