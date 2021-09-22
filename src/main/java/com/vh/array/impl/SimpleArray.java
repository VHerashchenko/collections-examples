package com.vh.array.impl;

import com.vh.array.iterator.ArrayIterator;
import com.vh.array.Simple;

import java.util.Iterator;

public class SimpleArray<E> implements Simple<E> {

    private E[] values;

    public SimpleArray(){
        this.values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];

            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;

            return true;
        } catch (ClassCastException exception){
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];

            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
