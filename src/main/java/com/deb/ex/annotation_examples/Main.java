package com.deb.ex.annotation_examples;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;

/*Annotations are a form of metadata that provide data about a program that is
not part of the program itself
There are 10 in-built annotations
Annotations can be applied to declarations:
declarations of classes, fields, methods, and other program elements
Annotations can also be applied to the use of types (type annotation)
e.g. new @Interned MyObject()

-Marker Annotation
(If the annotation has no elements, then the parentheses can be omitted
while using the annotation)
-Single Value Annotation
(If there is just one element named 'value', then the name can be omitted
while using the annotation)
-Multi Value Annotation
*/
public class Main {
    //category=deprecation or unchecked
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NoSuchMethodException{
        new Main();
        Class<DemoClass> demoClassObj = DemoClass.class;
        Method method = demoClassObj.getMethod("getString");
        readAnnotation(demoClassObj);
        readAnnotation(method);
    }

    static void readAnnotation(AnnotatedElement element){
        System.out.println("Finding annotations in "+element.getClass().getName());
        Annotation[] annotations = element.getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation instanceof ClassPreamble){
                ClassPreamble classPreamble = (ClassPreamble) annotation;
                System.out.println("Author: " + classPreamble.author());
                System.out.println("Current Version: "+classPreamble.currentVersion());
                System.out.println("Last modified by: "+classPreamble.lastModifiedBy());
                System.out.println("Reviewers: "+ Arrays.asList(classPreamble.reviewers()));
            }
        }
    }

    class A {
        public void show() {
            System.out.println("in A");
        }

        /**
         * @deprecated  use show() method instead
         */
        @Deprecated
        public void display() {
            System.out.println("In Display");
        }
    }

    class B extends A {

        @Override
        public void show() {
            System.out.println("In B");
        }
    }

    @FunctionalInterface
    interface C {
        public void trythis();
    }
}
