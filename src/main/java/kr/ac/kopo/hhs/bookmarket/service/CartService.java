package kr.ac.kopo.hhs.bookmarket.service;

import kr.ac.kopo.hhs.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
}
