package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;

import java.util.HashMap;
import java.util.Map;

public class Count {

    private Map<ProductVO, Integer> productQuantity;

    public Count() {
        this.productQuantity = new HashMap<>();
    }

    public void addProduct(ProductVO product) {
        if (product != null) {
            int count = productQuantity.getOrDefault(product, 0);
            productQuantity.put(product, count + 1);
        }
    }

    public Map<ProductVO, Integer> getProductQuantity() {
        return productQuantity;
    }
}
