package kr.ac.kopo.hhs.bookmarket.repository;

import kr.ac.kopo.hhs.bookmarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {
}
