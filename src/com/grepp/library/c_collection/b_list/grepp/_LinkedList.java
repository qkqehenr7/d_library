package com.grepp.library.c_collection.b_list.grepp;

import com.grepp.library.c_collection.z_domain.Node;

public class _LinkedList<E> implements _List<E> {

    private Node<E> head;
    private int pointer;

    public int size(){
        return pointer;
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    public boolean add(E e){
        Node<E> current = new Node<>(e);

        if (pointer == 0){
            head = current; // 포인터가 0이라면 현재 노드가 첫 노드라는 의미
            pointer++;
            return true;
        }

        Node<E> link = head; // 선택되는 다음 노드의 주소를 저장할 변수 link
        while (link.next() != null){
            link = link.next();
        }

        link.setNext(current); // 현재 노드를 마지막 노드의 다음 노드로 지정
        pointer++;
        return true;
    }

    public E get(int index){
        if (index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

        Node<E> link = head; // index 만큼 반복문이 돌면서
        for (int i = 0; i < index; i++) {
            link = link.next();
        }

        return link.data(); // 해당 인덱스의 값을 return
    }
}
