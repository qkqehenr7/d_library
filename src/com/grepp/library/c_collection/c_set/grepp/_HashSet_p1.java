package com.grepp.library.c_collection.c_set.grepp;

import java.util.Arrays;

public class _HashSet_p1<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int arraySize = 10;
    private Object[] elementData;
    private int size;

    public _HashSet_p1() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int hash(E e){
        // hashCode : -21억 ~ +21억
        // 0 ~ 21억 사이의 값 반환
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }

    public boolean add(E e){
        if (size == arraySize - 1){ // 배열이 가득차기 직전에 확장
            resize();
        }

        int index = hash(e);

        if (elementData[index] != null){ // 이미 Set 에 존재하는 값인 경우 add 불가능.
            return false;
        }

        elementData[index] = e;
        size++;
        return true;
    }

    private void resize(){
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == null) continue;
            int newIndex = hash((E) elementData[i]); // 강제 casting
            temp[newIndex] = elementData[i];
        }
        elementData = temp;
    }

    public boolean remove(E e){
        int index = hash(e);
        if (elementData[index] == null) return false; // 값이 존재하지 않으면 remove 불가
        elementData[index] = null; // 존재하는 경우 삭제
        size--;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
