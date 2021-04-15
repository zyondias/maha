package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;
import com.zyon.maha.application.promotion.Promotion;

import java.util.Map;
import java.util.Optional;

public class Calculate {

    public static int total(Map<ProductVO, Integer> productsAndTotal) {

        return productsAndTotal.entrySet().stream()
                .map(item -> totalProductPrice(item.getKey(), item.getValue()))
                .reduce(0, Integer::sum);
    }

    private static int totalProductPrice(ProductVO product, int quantity) {
        int totalPrice = product.getPrice() * quantity;

        Optional<Promotion> promotion = product.getPromotion();
        if (promotion.isPresent())
            totalPrice = totalPrice - promotion.get().amountToDiscount(product.getPrice(), quantity);

        return totalPrice;
    }
}
