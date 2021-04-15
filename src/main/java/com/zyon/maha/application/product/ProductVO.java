package com.zyon.maha.application.product;

import com.zyon.maha.application.promotion.Promotion;

public class ProductVO {

    private String id;
    private String name;
    private int price;
    private Promotion promotion;

    public ProductVO(String id, String name, int price, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promotion = promotion;
    }
}
