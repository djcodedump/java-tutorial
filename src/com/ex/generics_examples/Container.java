package com.ex.generics_examples;

import java.util.ArrayList;
import java.util.List;

public class Container<T extends Number> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void demo(ArrayList<? extends T> list) {

    }

    public void demo2(ArrayList<? super T> list) {

    }

    public <Z> Z noOp(Z val) {
        return val;
    }

    /*
    To get data from (list.get) > use extends
    To put data into (list.add) -> use super
     */
    public void copy(List<? extends T> src, List<? super T> dest) {

    }

    /*
    <?> is a raw type, it basically means <? extends Object>
     */
    public void reverse(List<?> src) {

    }

}
