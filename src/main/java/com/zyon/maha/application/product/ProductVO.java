package com.zyon.maha.application.product;

import com.zyon.maha.application.promotion.Promotion;

import java.util.Optional;

public class ProductVO {

    private String id;
    private String name;
    private int price;
    private Optional<Promotion> promotion;

    public ProductVO(String id, String name, int price, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promotion = Optional.ofNullable(promotion);
    }

    public int getPrice() {
        return price;
    }

    public Optional<Promotion> getPromotion() {
        return promotion;
    }
}
