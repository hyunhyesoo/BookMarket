package kr.ac.kopo.hhs.bookmarket.service;

import kr.ac.kopo.hhs.bookmarket.domain.Book;
import kr.ac.kopo.hhs.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }
}
