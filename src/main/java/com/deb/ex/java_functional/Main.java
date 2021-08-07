package com.deb.ex.java_functional;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.deb.ex.java_functional.Main.Gender.*;

public class Main {

    /**
     * Package java.util.function
     * There are several basic function shapes, including
     * Function (unary function from T to R)
     * Consumer (unary function from T to void)
     * Predicate (unary function from T to boolean)
     * and Supplier (nullary function to R)
     */
    public static void main(String[] args) {

        //usingFunction();

        //usingConsumer();

        //usingPredicate();

        //usingSupplier();

        usingFuctionalProg();


    }

    private static void usingSupplier() {

        Supplier<List<String>> nameSupplier = () -> List.of("Deba", "Deep", "Deepa", "Deepti");
        System.out.println(nameSupplier.get());
    }

    private static void usingConsumer() {

        Consumer<Person> consumer = p -> System.out.println("Hi " + p.name + ", your gender is " + p.gender);
        consumer.accept(new Person("Deep", MALE));

        BiConsumer<Person, Boolean> biConsumer =
                (p, q) -> System.out.println("Hi " + p.name + ", your gender is " + (q ? p.gender : "*****"));
        biConsumer.accept(new Person("Deep", MALE), false);

    }

    private static void usingFunction() {

        System.out.println(increment(1));

        //Function
        Function<Integer, Integer> incrementByOneFunction = num -> num + 1;
        int increment = incrementByOneFunction.apply(1);

        Function<Integer, Integer> multiplyByTenFunction = num -> num * 10;
        int multiply = multiplyByTenFunction.apply(2);

        Function<Integer, Integer> resultFunction = incrementByOneFunction.andThen(multiplyByTenFunction);

        System.out.println(resultFunction.apply(1));

        //BiFunction
        BiFunction<Integer, Integer, Integer> incAndMultiplyBiFunction = (x, y) -> (x + 1) * y;
        System.out.println(incAndMultiplyBiFunction.apply(1, 10));

    }

    public static int increment(int num) {
        return num + 1;
    }

    private static void usingPredicate() {

        //Predicate is an interface with a single valued function returning a boolean
        Predicate<Person> personPredicate1 = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.gender.equals(MALE);
            }
        };
        System.out.println(personPredicate1.test(new Person("Deepa", FEMALE)));

        Predicate<Person> personPredicate2 = person -> person.gender.equals(MALE) || person.name.startsWith("D");
        System.out.println(personPredicate2.test(new Person("Deepa", FEMALE)));

        BiPredicate<Person, Gender> biPredicate = (p, g) -> p.gender.equals(g);
        System.out.println(biPredicate.test(new Person("Deep", MALE), FEMALE));


    }

    private static void usingFuctionalProg() {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Alisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        List<Person> females = people.stream()
                .filter(p -> p.gender.equals(FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);
    }


    @ToString
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE;
    }
}
