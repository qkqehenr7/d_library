package com.grepp.library.c_collection.c_set.grepp;

import com.grepp.library.c_collection.z_domain.Node;

@SuppressWarnings("unchecked")
public class _HashSet_p2 <E>{

    private static final int DEFAULT_CAPACITY = 10;
    private int arraySize = 10;
    protected Object[] elementData;
    private int size;

    public _HashSet_p2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    protected int hash(E e){
        // hashCode : -21억 ~ +21억
        // 0 ~ 21억 사이의 값 반환
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
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

    public boolean add(E e){
        Node<E> node = new Node<E>(e); // node는 참조 타입임.

        if (size == arraySize-1){
            resize();
        }

        int index = hash(e);
        Node<E> head = (Node<E>) elementData[index]; // 첫 번째 노드는 elementData의 index에 위치하는 노드

        if (head == null){              // input 값이 Set에 없는 경우
            elementData[index] = node;
            size++;
            return true;
        }

        Node<E> link = head; // link 노드에 head 할당
        while (link.next() != null){ // link 의 다음 노드가 없을때까지 반복
            if (link.equals(node)) return false; // 중복값이 존재하면 false 반환
            link = link.next();
        }

        link.setNext(node); // input 값이 들어있는 노드를 link의 다음 노드로 지정
        size++;
        return true;
    }

    public boolean remove(E e){
        int index = hash(e);
        Node<E> head = (Node<E>) elementData[index];

        if (head.data().equals(e)){
            elementData[index] = head.next(); // 참조를 다음 노드로 옮겼으므로 이전의 노드는 GC에 의해 삭제됨
            size--;
            return true;
        }

        Node<E> prevNode = head;
        Node<E> link = head;

        while (link.next() != null){
            prevNode = link;        // 하나씩 다음 노드로 옮김
            link = link.next();

            if (link.data().equals(e)){ // 새로운 연결 노드의 값이 지우려는 값과 같으면
                prevNode.setNext(link.next()); // 이전 노드의 참조를 다음 노드로 변경함
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == null) continue;
            Node<E> link = (Node<E>) elementData[i];

            while (link.next() != null){
                sb.append(link.data()).append(","); // 메서드 체인방식
                link = link.next();
            }

            sb.append(link.data());
            if (i != elementData.length-1) sb.append(",");
        }

        sb.append("]");
        return sb.toString();


    }
}
