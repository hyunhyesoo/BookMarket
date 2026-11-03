package kr.ac.kopo.hhs.bookmarket.repository;

import kr.ac.kopo.hhs.bookmarket.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
