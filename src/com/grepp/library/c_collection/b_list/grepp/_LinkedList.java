package com.grepp.library.c_collection.b_list.grepp;

import com.grepp.library.c_collection.z_domain.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class _LinkedList<E> implements _List<E>, Iterable<E> {

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

    public E set(int index, E e){
        if (index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

        Node<E> link = head;

        for (int i = 0; i < index; i++) {
            link = link.next();
        }

        E modified = link.data(); // 이전 데이터값 추출
        link.setData(e); //데이터 수정
        return modified; // 이전 데이터값 출력
    }

    public E remove(int index){
        if (index < 0 || index >= pointer) throw new IndexOutOfBoundsException();
        // 삭제는 삭제할 노드의 앞 뒤 노드가 필요.
        Node<E> link = head;
        Node<E> prevNode = head;

        if(index == 0){
            head = head.next(); // 첫 노드를 삭제하는 경우 두 번째 노드를 head 에 이어주면 끝
            pointer--;
            return prevNode.data();
        }

        for (int i = 0; i < index; i++) {
            prevNode = link; // 이전 노드 정보 저장
            link = link.next();
        }

        prevNode.setNext(link.next());
        pointer--;
        return link.data();
    }

    // todo contain 메서드 구현
    public boolean contains(E e){
        Node<E> link = head;
        while(link != null){
            if (link.data().equals(e)){ // 링크를 돌면서 중복이 있다면 return true
                return true;
            }
            link = link.next();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // Iterable의 익명 클래스 생성
        return new Iterator<E>() {

            private int pointer;
            @Override
            public boolean hasNext() {
                return pointer < size();
            }

            @Override
            public E next() {
                if (pointer >= size()) throw new NoSuchElementException();
                E e = get(pointer);
                pointer++;
                return e;
            }
        };
    }
}
