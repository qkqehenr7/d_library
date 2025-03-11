package com.grepp.library.c_collection.a_generic.domain;

public class Tv extends Device {

    private int size;

    public Tv(String name, int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Tv{" +
            "size=" + size +
            '}';
    }
}
