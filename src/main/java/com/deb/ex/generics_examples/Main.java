package com.deb.ex.generics_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
Java Generics are a language feature that allows for definition
Generics enable types (classes and interfaces) to be parameters
when defining classes, interfaces and methods
Type parameters provide a way for you to re-use the same code with different inputs

Generics force type safety in java language. Without this type of safety,
the code could have infected by various bugs that get revealed only in runtime
avoid {@link ClassCastException}

An invocation of a generic type is generally known as a parameterized type
Generic types are instantiated to form parameterized types by providing
actual type arguments that replace the formal type parameters.
LinkedList<E> is a generic type
LinkedList<Integer> is a parameterized type

The T in Foo<T> is a type parameter and the String in Foo<String> is a type argument

Generics not compatible with primitives
You cannot write: List<int> lst = new ArrayList<>();

Array is covariant but generic Collection is invariant
.i.e. an array of supertype references is a supertype of an
 array of subtype references
 Object[] is a supertype of String[]
 List<Object> is not a supertype of List<String>

Conventions:
 E - Element (used extensively by the Java Collections Framework)
 K - Key
 N - Number
 T - Type
 V - Value
 S,U,V etc. - 2nd, 3rd, 4th types

In the Collections framework, generics add this type checking of parameters
in the code at compile-time, automatically

'type erasure' essentially means that all the extra information added using
generics into source code will be removed from bytecode generated from it

**/
public class Main {

    public static void main(String[] args) {
        test();
    }


    static void test(){

        List<Object> objlst = new ArrayList<>();
        List<String> strlst = new ArrayList<>();

        //objlst = strlst; not possible, invariants

        Object[] objArr = new Object[5];
        String[] strArr = new String[5];

        objArr = strArr;//possible, covariants


        List<Integer> list1 = Arrays.asList(123,321,542);

        Collections.sort(list1, (o1, o2) -> (o1%10 - o2%10));

        list1.forEach(System.out::println);

        List<Integer> list2 = new ArrayList<>()
        {{
            add(121);
            add(211);
            add(345);
        }};

        list2.forEach(System.out::println);

    }
}
