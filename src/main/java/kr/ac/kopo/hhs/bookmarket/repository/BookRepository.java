package kr.ac.kopo.hhs.bookmarket.repository;

import kr.ac.kopo.hhs.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
}
