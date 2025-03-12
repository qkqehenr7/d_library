package com.grepp.library.c_collection.a_generic;

import com.grepp.library.c_collection.a_generic.domain.Device;


// NOTE A01 : Generic
// 클래스 외부에서 클래스 내부에서 사용할 타입을 결정하는 것.
// 클래스 선언부나 메서드 선언부에 <Generic 매개변수> 를 선언해 사용가능
// Generic 은 여러 개 사용할 수 있다.
public class GenericArray<E> {

    private Object[] elements; // shift + F6으로 변수명 변경
    private int size;
    private int pointer;

    public GenericArray(int size) {
        this.size = size;
        elements = new Object[size]; // 외부에서 접근 못하도록 안에서 생성
    }

    // NOTE 02 Generic Method
    public static <T> GenericArray<T> practiceGeneric(T a) {

        GenericArray<T> instance = new GenericArray<>(10);
        instance.add(a);
        return instance;
    }

    // NOTE 03 타입 한정 키워드
    // T extends Device : Device 타입을 포함한 후손 타입
    public static <T extends Device> GenericArray<T> practiceExtends(T e){
        GenericArray<T> instance = new GenericArray<>(10);
        instance.add(e);
        return instance;
    }



    public int size(){
        return size;
    }

    public void add(E e){

        if (pointer == size){
            //throw new ArrayIndexOutOfBoundsException(); // 예외를 던져도 된다.
            System.out.println("용량이 부족합니다.");
            return;
        }

        elements[pointer] = e; // pointer가 가르키는 위치에 넣기
        pointer ++;
    }

    public E get(int idx){
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
        return (E) elements[idx];
    }
}
