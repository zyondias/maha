package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;
import com.zyon.maha.application.promotion.ComboProductPromotion;
import com.zyon.maha.application.promotion.Promotion;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CalculateTest {

    private Promotion promotion = new ComboProductPromotion(2, 150);
    private ProductVO rolex = new ProductVO("001", "Rolex", 100, null);
    private ProductVO dummont = new ProductVO("002", "Dummont", 200, promotion);

    @Test
    public void shouldReturnRightTotalPrice() {
        Map<ProductVO, Integer> productQuantity = new HashMap<>();
        productQuantity.put(rolex, 7);

        int result = Calculate.total(productQuantity);

        Assert.assertEquals(700, result);
    }

    @Test
    public void shouldReturnRightTotalPriceWithMoreOneProductAndProductWithDiscount() {
        Map<ProductVO, Integer> productQuantity = new HashMap<>();
        productQuantity.put(rolex, 7);
        productQuantity.put(dummont, 5);

        int result = Calculate.total(productQuantity);

        Assert.assertEquals(1200, result);
    }

    @Test
    public void shouldReturnZeroWhenMapIsEmpty() {
        Map<ProductVO, Integer> productQuantity = new HashMap<>();

        int result = Calculate.total(productQuantity);

        Assert.assertEquals(0, result);
    }
}
