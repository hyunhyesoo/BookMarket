package kr.ac.kopo.hhs.bookmarket.service;

import kr.ac.kopo.hhs.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrder(String bookId, long quantity);
    Long saveOrder(Order order);
}
