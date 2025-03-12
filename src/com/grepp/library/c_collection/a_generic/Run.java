package com.grepp.library.c_collection.a_generic;

import com.grepp.library.c_collection.a_generic.domain.Book;
import com.grepp.library.c_collection.a_generic.domain.Computer;
import com.grepp.library.c_collection.a_generic.domain.Device;
import com.grepp.library.c_collection.a_generic.domain.SmartPhone;
import com.grepp.library.c_collection.a_generic.domain.Tv;

public class Run {

    public static void main(String[] args) {

        Computer mac = new Computer("mac", "apple");
        Computer galaxyBook = new Computer("galaxyBook", "intel");
        SmartPhone iphone = new SmartPhone("iphone", "M4", "SKT");
        SmartPhone galaxy = new SmartPhone("galaxy", "Snapdragon", "SKT");
        Book book = new Book("해리포터", "조앤롤링");
        Tv tv = new Tv("스탠바이미", 50);

        GenericArray<Device> devices = new GenericArray<>(2);
        devices.add(tv);
        devices.add(galaxyBook);
        //devices.add(book); 타입 에러가 발생

        for (int i = 0; i < devices.size(); i++) {
            //System.out.println(devices.get(i));
            //devices.get(i); // get 메서드에 대해서 알아봐야 할듯
            devices.get(i).on();
        }

        GenericArray<Book> books = new GenericArray<>(2);
        books.add(book);
        System.out.println(books.get(0));

        // Generic Method 를 사용할 때는
        // 매개변수, 반환타입을 기반으로 컴파일러가 제네릭 타입을 추론
        GenericArray<Device> g1 = GenericArray.<Device>practiceGeneric(mac);
        // T extends Device : Device 타입을 가지고 있지 않은 Book 은 올 수 없다.
        //GenericArray<Book> g2 = GenericArray.<Book> practiceExtends(book);
        GenericArray<Device> g2 = GenericArray.<Device> practiceExtends(mac);

        // NOTE 04 Generic 은 무공변성이다. >> casting 불가능
        // GenericArray<Device>은 GenericArray<Computer>의 상위 타입이 아님
        //GenericArray<Device> g3 = GenericArray.<Computer> practiceExtends(mac);

        // NOTE 05 와일드카드 : ?
        // Generic Method 에서는 사용할 수 없다.
        // 상한 경계 : <? extends T>
        // GenericArray<? extends Device>이 Device의 후손타입을 제네릭 타입으로 가지는
        // GenericArray<T>에 대해 상위 타입이 된다.
        GenericArray<? extends Device> g3 = GenericArray.<Computer> practiceExtends(mac);

        // NOTE 04 하한 경계
        // <? super T>
        // T 타입의 선조타입
        GenericArray<? super Computer> g4 = GenericArray.<Device> practiceGeneric(mac);





    }
}
