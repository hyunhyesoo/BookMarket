package kr.ac.kopo.hhs.bookmarket.service;

import kr.ac.kopo.hhs.bookmarket.domain.Book;
import kr.ac.kopo.hhs.bookmarket.domain.Order;
import kr.ac.kopo.hhs.bookmarket.repository.BookRepository;
import kr.ac.kopo.hhs.bookmarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private BookRepository bookRepository;

    private OrderRepository orderRepository;

    @Override
    public void confirmOrder(String bookId, long quantity) {
        Book bookById = bookRepository.getBookById(bookId);
        if (bookById.getUnitsInStock() < quantity)
            throw new IllegalArgumentException("도서 수량이 부족합니다. 구입 가능한 수량은" + bookById.getUnitsInStock() + "입니다.");

        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
    }

    @Override
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        return orderId;
    }

}
