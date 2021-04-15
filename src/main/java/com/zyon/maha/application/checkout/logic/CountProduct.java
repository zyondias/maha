package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;

import java.util.HashMap;
import java.util.Map;

public class CountProduct {

    private Map<ProductVO, Integer> products;

    public CountProduct() {
        this.products = new HashMap<>();
    }

    public void addProduct(ProductVO product) {
        int count = products.getOrDefault(product, 0);
        products.put(product, count + 1);
    }

    public Map<ProductVO, Integer> getProducts() {
        return products;
    }
}
