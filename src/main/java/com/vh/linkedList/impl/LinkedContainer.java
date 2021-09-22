package com.vh.linkedList.impl;

import com.vh.linkedList.Linked;
import com.vh.linkedList.iterator.LinkedIterator;

import java.util.Iterator;

public class LinkedContainer<E> implements Linked<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;

    private int size = 0;

    public LinkedContainer(){
        this.lastNode = new Node<>(null, firstNode, null);
        this.firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.currentElement = e;

        lastNode = new Node<>(null, prev, null);
        prev.nextElement = lastNode;

        ++size;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.currentElement = e;

        firstNode = new Node<>(null, null, next);
        next.previousElement = firstNode;

        ++size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.nextElement;

        for (int i = 0; i < counter; ++i){
            target = target.nextElement;
        }
        return target.currentElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator<>(this);
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> previousElement;

        private Node(E currentElement, Node<E> previousElement, Node<E> nextElement){
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.previousElement = previousElement;
        }
    }
}