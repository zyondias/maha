package com.zyon.maha.application.product;

import com.zyon.maha.application.discount.Discount;

public class ProductVO {

    private String id;
    private String name;
    private int price;
    private Discount discount;

    public ProductVO(String id, String name, int price, Discount discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
}
