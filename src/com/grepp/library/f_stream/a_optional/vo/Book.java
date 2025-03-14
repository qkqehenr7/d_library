package com.grepp.library.f_stream.a_optional.vo;

// NOTE E01 Record
// 도메인 객체 : 역할과 책임을 가지고 있는 객체
// 데이터 객체 : 데이터를 저장하기 위한 객체
//      DTO : Data Transfer Object (mutable, setter가 다 있다.)
//      VO : Value Object (immutable)

// record == vo
// 불변 데이터 클래스 (필드는 private final)
// 속성명으로 getter 자동 생성, getTitle(X) > title(O)
// equals, hashcode, toString 자동 Overriding
public record Book(
    String title,
    String author,
    Integer price,
    Boolean activated
) {

    public Book(){
        this("", "", null, null);
    }
}
