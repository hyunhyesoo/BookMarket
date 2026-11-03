package kr.ac.kopo.hhs.bookmarket.repository;

import kr.ac.kopo.hhs.bookmarket.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private Map<Long, Order> listOfOrders;
    private long nextOrderId;

    public OrderRepositoryImpl(){
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 2000;
    }
    @Override
    public Long saveOrder(Order order) {
        order.setOrderId(nextOrderId);
        listOfOrders.put(order.getOrderId(), order);
        return 0L;
    }

    private synchronized long getNextOrderId(){
        return nextOrderId++;
    }
}
