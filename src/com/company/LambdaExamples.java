package com.company;

import java.util.Comparator;

//Lambda expression can implement interfaces with a single abstract method
//The interface can have as many default or static methods
//such an interface is called a 'functional interface' (Comparator, Runnable, ActionListener etc.)
//Lambda expressions are stateless, i.e. they cannot have any member variables

public class LambdaExamples {

    interface MyFunction {
        public void apply();
    }

    interface MyAnotherFunction {
        public void printThis(String text);
    }

    interface MyAnotherFunction2 {
        public void printThis(String text1, String text2);
    }

    static String stStr = "static variable";

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
        System.out.println("myComparatorLambda2: " + myComparatorLambda2.compare("hello World", "hello"));

        MyFunction myFunction =
                () -> System.out.println("hello world");

        myFunction.apply();

        callMe(myFunction);

        MyAnotherFunction myAnotherFunction =
                text -> System.out.println(text);
        myAnotherFunction.printThis("Hello another function");

        final String str = "My name is ";

        MyAnotherFunction2 myAnotherFunction2 = (text1, text2) -> System.out.println(str + text1 + " " + text2
        +", and this is " + stStr);
        myAnotherFunction2.printThis("Debajyoti", "Nath");

        stStr ="changed value of static variable";

        myAnotherFunction2.printThis("Debajyoti", "Nath");

    }

    static void callMe(MyFunction myFunc){
        System.out.println("Called from 'callMe'");
        myFunc.apply();
    }
}
