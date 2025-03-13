package com.grepp.library.c_collection.c_set.grepp;

import com.grepp.library.c_collection.z_domain.Node;

public class _HashSet_p3 <E>{

    private Node<E> head;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean add(E e){
        Node<E> node = new Node<>(e);
        if (size == 0){
            head = node; // size 가 0이라면 현재 노드가 첫 번째 노드
            size++;
            return true;
        }

        Node<E> link = head; // 선택되는 다음 노드의 주소를 저장할


        return true;
    }

    public boolean remove(E e){
        return true;
    }
}
