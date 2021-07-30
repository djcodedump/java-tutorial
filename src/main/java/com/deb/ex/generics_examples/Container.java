package com.deb.ex.generics_examples;

import java.util.List;

/**
Generic Type Class or Interface
A class is generic if it declares one or more type variables
Scope of the generic type is within the class
These type variables are known as the type parameters of the class

Once initialized the class with a certain type, class should be used
with that particular type only
 **/
public class Container<T, C> {
    private T val;
    private C name;

    //cannot have a static generic type field
    //private static T member; // doesn't compile

    public Container(T val, C name) {
        this.val = val;
        this.name = name;
    }

    /*
    A generic constructor is a constructor that introduces its own type parameters
    A non generic class can have a generic constructor
    */
    public <Z> Container(Z other){
        //this.value = other;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    /*
    A generic method can introduce its own type parameters.
    the type parameter's scope is limited to the method where it is declared.
     */
    public <K, V> boolean equality(Pair<K, V> pair1, Pair<K, V> pair2){
        return pair1.getValue().equals(pair2.getValue());
    }

    /* wildcard (?), represents an unknown type
    <?> is a raw type, an unbounded wildcard, it basically means <? extends Object>
     */
    public void reverse(List<?> src) {

    }

    /*
    Bounded wildcard put some restrictions over possible types

    <? extends Number> defines the upper bound to be Number,
    so it includes Number and all its subclasses
    <? super Number> defines the lower bound to be Number,
    so it includes Number and all its superclasses

    To get data from (list.get) > use extends (upper bound)
    To put data into (list.add) -> use super (lower bound)
     */
    public void copy(List<? extends Number> src, List<? super Number> dest) {

    }

    //multiple bounds
    public <M extends T, C> void tryThis(M obj1){

    }

    public static void main(String[] args) {

        Container<Number, String> con = new Container<>("my container");

        Pair<Integer, String> pair1 = new Pair<>(1, "name1");
        Pair<Integer, String> pair2 = new Pair<>(2, "name2");

        con.<Integer, String>equality(pair1,pair2);
        con.equality(pair1,pair2);//with type inference
    }

    //Generic class cannot extend Throwable
    //class MyException<T> extends Exception{ }

}
