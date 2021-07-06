package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

interface Parser{
    String parse(String str);
}

class StringParser{
    public static String convert(String str){
        if(str.length()<=3){
            str = str.toUpperCase();
        }else{
            str = str.toLowerCase();
        }
        return str;
    }
}

class MyPrinter{
    public void print(String str, Parser p){
        System.out.println(p.parse(str));
    }
}

public class MethodReferenceExamples {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Deba","Bijit", "Dip", "Soma", "Surajit", "Sandip", "Raju");

        String str = "Deb";

        MyPrinter mp = new MyPrinter();

        mp.print(str, StringParser::convert);

    }
}
