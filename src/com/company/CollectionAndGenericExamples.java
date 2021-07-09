package com.company;

import java.io.Serializable;
import java.sql.Array;
import java.util.*;

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
        test1();
        //test2();

    }

    static void test1(){
        Container<Number> con = new Container<>();

        con.demo(new ArrayList<Integer>());

        con.demo2(new ArrayList<Serializable>());

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

    static void test2(){

        Map<String, String> map = new HashMap<>();
        map.put("name1", "Deba");
        map.put("name2", "Dip");
        map.put("name3", "Sumit");

        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() +"|" + entry.getValue());
        }

    }
}
