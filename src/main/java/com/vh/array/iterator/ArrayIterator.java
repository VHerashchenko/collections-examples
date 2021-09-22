package com.vh.array.iterator;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private final E[] values;

    public ArrayIterator(E[] values){
        this.values = values;
    }

    @Override
    public boolean hasNext(){
        return index < values.length;
    }

    @Override
    public E next(){
        return values[index++];
    }

    @Override
    public void remove(){
        Iterator.super.remove();
    }
}