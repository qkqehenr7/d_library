package com.grepp.library.c_collection.d_map.grepp;

import com.grepp.library.c_collection.c_set.grepp._HashSet_p2;
import com.grepp.library.c_collection.z_domain.Node;

public class _EntrySet<E> extends _HashSet_p2<E> {

    _EntrySet() {
    }

    @Override
    public boolean add(E e) {
        if (get(e) != null){        // Entry Set에 중복이 있으면 기존 원소 제거 후 추가
            super.remove(e);        // super : 자식 클래스에서 부모 클래스를 가리킬 떄 사용
        }
        return super.add(e);
    }

    public E get(E e){
        int index = hash(e);
        Node<E> head = (Node<E>) elementData[index];

        if (head == null) return null;
        if (head.equals(e)) return head.data();

        Node<E> link = head;
        while (link != null){
            if (link.data().equals(e)){
                return link.data();
            }
            link = link.next();
        }

        return null;
    }

}
