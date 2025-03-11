package com.grepp.library.c_collection.a_generic;

import com.grepp.library.c_collection.a_generic.domain.Book;
import com.grepp.library.c_collection.a_generic.domain.Computer;
import com.grepp.library.c_collection.a_generic.domain.Device;
import com.grepp.library.c_collection.a_generic.domain.Tv;

public class Run {

    public static void main(String[] args) {

        Book book = new Book("해리포터", "조앤롤링");
        Device computer = new Computer("갤럭시북", "intel");
        Device tv = new Tv("스탠바이미", 50);

        GenericArray<Device> devices = new GenericArray<>(2);
        devices.add(tv);
        devices.add(computer);
        //devices.add(book); 타입 에러가 발생

        GenericArray<Book> books = new GenericArray<>(2);
        books.add(book);

        System.out.println(books.get(0));
        for (int i = 0; i < devices.size(); i++) {
            //System.out.println(devices.get(i));
            //devices.get(i); // get 메서드에 대해서 알아봐야 할듯
            devices.get(i).on();
        }
    }
}
