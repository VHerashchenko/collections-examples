package com.vh.linkedList;

import java.util.Iterator;

public interface Linked<E> extends Iterable<E> {

    void addLast(E e);

    void addFirst(E e);

    int size();

    E getElementByIndex(int counter);
}