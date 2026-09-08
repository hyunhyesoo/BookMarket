package kr.ac.kopo.hhs.bookmarket.repository;

import kr.ac.kopo.hhs.bookmarket.domain.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryImpl implements CartRepository{
    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("장바구니를 새로 생성할 수 없습니다 장바구니 &s 아이디가 이미 존재합니다", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }
}
