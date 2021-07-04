package com.company;

import java.util.Comparator;

//Lambda expression used for implementing single method interfaces
public class LambdaExamples {

    public static void main(String[] args) {

        //Without Lambda
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("myComparator: " + myComparator.compare("hello World", "hello"));

        //With Lambda

        Comparator<String> myComparatorLambda =
                (String o1, String o2) -> {
                    return  o1.compareTo(o2);
                };
        System.out.println("myComparatorLambda: "+ myComparatorLambda.compare("hello World", "hello"));

        Comparator<String> myComparatorLambda2 =
                (o1, o2) ->  o1.compareTo(o2);
        System.out.println("myComparatorLambda2: "+ myComparatorLambda2.compare("hello World", "hello"));

    }
}
