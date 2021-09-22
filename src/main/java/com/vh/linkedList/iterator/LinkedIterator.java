package com.vh.linkedList.iterator;

import com.vh.linkedList.Linked;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E> {

        private Linked<E> values;
        private int counter = 0;

        public LinkedIterator(Linked<E> values){
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return counter < values.size();
        }

        @Override
        public E next() {
            return values.getElementByIndex(counter++);
        }
}