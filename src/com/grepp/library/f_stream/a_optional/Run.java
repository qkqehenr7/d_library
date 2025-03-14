package com.grepp.library.f_stream.a_optional;

import com.grepp.library.f_stream.a_optional.error.NotFoundException;
import com.grepp.library.f_stream.a_optional.vo.Book;
import java.util.Optional;

public class Run {

    public static void main(String[] args) {

        _Optional optional = new _Optional();

        // NOTE F02 Optional get
        // 없으면 NoSuchElementException
        //Optional<Book> res = new _Optional()

        Book book = optional.findBook("해리포터")
            .get();
        System.out.println(book);

        book = optional.findBook("해리포터2")
            .orElse(new Book());

        System.out.println(book);

        book = optional.findBook("해리포터")
            .orElseThrow();

        System.out.println(book);

        book = optional.findBook("해리포터2")
            .orElseThrow(() -> new NotFoundException("지정한 도서가 없습니다."));
    }

}
