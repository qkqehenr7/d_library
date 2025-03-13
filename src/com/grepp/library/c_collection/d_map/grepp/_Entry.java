package com.grepp.library.c_collection.d_map.grepp;

import java.util.Objects;

public class _Entry<K, V> {
    // _Entry 클래스의 필드 선언
    private K key;
    private V value;

    // 생성자 블록에서 초기화
    public _Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof _Entry<?, ?> entry)) {
            return false;
        }
        return Objects.equals(key, entry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return "_Entry{" +
            "key=" + key +
            ", value=" + value +
            '}';
    }
}
