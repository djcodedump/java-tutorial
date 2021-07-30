package com.deb.ex.streamapi_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        int num = 89_3_42;

        //test1();
        //test2();
        //test3();
        test4();
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
        list.forEach(Main::doubleit);

    }
    static void doubleit(int i){
        System.out.println(i * 2);
    }

    static void test2() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * 2;
            }
        };

        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                return i + j;
            }
        };

        System.out.println(list.stream().map(f).reduce(0, b));

        System.out.println(list.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e));

        System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));
    }

    static void test3() {
        List<Integer> list = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

        Integer result = 0;
        for(Integer i : list){
            if(i%5 == 0){
                result += i;
            }
        }
        System.out.println(result);

        System.out.println(list.stream()
                                .filter(i -> i % 5 == 0)
                                .reduce(0, Integer::sum));


        List<Integer> list2 = Arrays.asList(20, 88, 99);

        System.out.println(list2.stream()
                                    .filter(i -> i % 5 == 0)
                                    .map(i -> i * 2)
                                    .findFirst()
                                    .orElse(0));


    }

    static void test4(){
        List<Integer> list = Arrays.asList(12, 20, 35, 46, 55, 68, 75);

        System.out.println(list.stream()
                .filter(Main::isDivisibleByFive)
                .map(Main::mapDouble)
                .findFirst()
                .orElse(0));

    }

    static boolean isDivisibleByFive(int i){
        System.out.println("in isDivisibleByFive: " + i);
        return i % 5 ==0;
    }

    static int mapDouble(int i){
        System.out.println("in mapDouble: "+ i);
        return i * 2;
    }
}
