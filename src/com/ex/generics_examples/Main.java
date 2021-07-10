package com.ex.generics_examples;

import java.io.Serializable;
import java.sql.Array;
import java.util.*;

class Container<T extends Number> {
    private T value;

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

    public <Z> Z noOp(Z val){
        return  val;
    }

    /*
    To get data from (list.get) > use extends
    To put data into (list.add) -> use super
     */
    public void  copy(List<? extends T> src, List<? super T> dest){

    }

    /*
    <?> is a raw type, it basically means <? extends Object>
     */
    public void reverse (List<?> src){

    }

}


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
