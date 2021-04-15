package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;

import java.util.HashMap;
import java.util.Map;

public class Count {

    private Map<ProductVO, Integer> productAndTotal;

    public Count() {
        this.productAndTotal = new HashMap<>();
    }

    public void addProduct(ProductVO product) {
        int count = productAndTotal.getOrDefault(product, 0);
        productAndTotal.put(product, count + 1);
    }

    public Map<ProductVO, Integer> getProductAndTotal() {
        return productAndTotal;
    }
}
