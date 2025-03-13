package com.grepp.library.c_collection.d_map.grepp;

import com.grepp.library.c_collection.c_set.grepp._HashSet_p2;
import com.grepp.library.c_collection.z_domain.Node;

public class _EntrySet<E> extends _HashSet_p2<E> {
    _EntrySet<E>{

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

        return link.data();
    }

}
