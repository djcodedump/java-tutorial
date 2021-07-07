package com.company;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

class Container<T extends Number> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void demo(ArrayList<? extends T> list){

    }

    public void demo2(ArrayList<? super T> list){

    }
}

public class CollectionAndGenericExamples {

    public static void main(String[] args) {

        Container<Number> con = new Container<>();

        con.demo(new ArrayList<Integer>());

        con.demo2(new ArrayList<Serializable>());


    }
}
