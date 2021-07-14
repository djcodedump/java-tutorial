package com.ex.annotation_examples;

import java.util.ArrayList;
import java.util.List;

class A {
    public void show(){
        System.out.println("in A");
    }

    @Deprecated
    public void display(){
        System.out.println("In Display");
    }
}

class B extends A{

    @Override
    public void show(){
        System.out.println("In B");
    }
}

public class Main {

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        A a = new A();
        a.display();

        List lst = new ArrayList();

    }
}
