package com.grepp.library.c_collection.b_list;

import com.grepp.library.c_collection.b_list.grepp._ArrayList;
import com.grepp.library.c_collection.b_list.grepp._LinkedList;
import com.grepp.library.c_collection.z_domain.School;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        // NOTE B01 : CRUD
        // 데이터를 조작하는 방법
        // Create, Read, Update, Delete
        //pracAdd();
        //pracGet();
        //pracSet();
        //pracRemove();
        //pracSort();
        pracIterable();

    }

    private static void pracIterable() {
        _LinkedList<Integer> list = new _LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }

    private static void pracSort() {
        School seoul = new School("서울대", "관악구", 4);
        School yonsei = new School("연세대", "신촌", 4);
        School minsa = new School("민사고", "대전", 3);
        School grepp = new School("그렙", "삼성", 10);
        School semyoung = new School("세명초", "속초", 1);

        List<School> schools = new ArrayList<>(List.of(seoul, yonsei, minsa, grepp, semyoung));
        List<Integer> nums = new ArrayList<>(List.of(3,123,52,12,66,352,88,3124));

        Collections.sort(nums);
        System.out.println(nums);
        Collections.sort(schools);
        System.out.println(schools);
    }

    private static void pracRemove() {
        _LinkedList<Integer> list = new _LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        list.remove(2);

        for (int i = 0; i < 9; i++) {
            System.out.println(list.get(i));
        }

        // 0, 1, 2, 3 번 인덱스 삭제
//        List<Integer> subList = list.subList(0, 4);
//        list.removeAll(subList);
//        System.out.println(list);
    }

    private static void pracSet() {
        School seoul = new School("서울대", "관악구", 4);
        School yonsei = new School("연세대", "신촌", 4);
        School minsa = new School("민사고", "대전", 3);
        School grepp = new School("그렙", "삼성", 10);
        School semyoung = new School("세명초", "속초", 1);

        _LinkedList<School> list = new _LinkedList<>();
        list.add(seoul);
        list.add(yonsei);
        System.out.println(list.get(0));

        list.set(0, grepp);
        System.out.println(list.get(0));

    }

    private static void pracGet() {
        List<String> list = new ArrayList<>();
        list.add("안녕");
        list.add("hi");
        list.add("hello");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void pracAdd() {
        _ArrayList<Integer> list = new _ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        for (int i = 0; i <  30; i++) {
            System.out.println(list.get(i) + " ");
        }

        System.out.println("\n===============================");
    }
}
