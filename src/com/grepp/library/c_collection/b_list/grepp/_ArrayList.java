package com.grepp.library.c_collection.b_list.grepp;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class _ArrayList <E> implements Iterable <E> {


    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int pointer;
    private int arraySize;

    public _ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        arraySize = DEFAULT_CAPACITY;
    }

    public boolean add(E e){

        if(pointer < arraySize){
            elementData[pointer] = e;
            pointer++;
            return true;
        }

        arraySize *= 2;
        Object[] temp = new Object[arraySize]; // 길이 2배의 array 생성

        for (int i = 0; i < pointer; i++) {
            temp[i] = elementData[i];
        }

        temp[pointer] = e;
        elementData = temp;
        pointer++;
        return true;
    }

    public E get(int index){
        if (index <0 || index >= pointer) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
        return (E) elementData[index];
    }

    public int size(){
        return pointer;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}

// remove, set 도 구현하기