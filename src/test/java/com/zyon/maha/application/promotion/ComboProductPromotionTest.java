package com.zyon.maha.application.promotion;


import org.junit.Assert;
import org.junit.Test;

public class ComboProductPromotionTest {

    @Test
    public void shouldGetDiscountTo6ProductWhenConditionProductIs3AndQuantityIs7() {

        ComboProductPromotion promotion = new ComboProductPromotion(3, 200);

        int amountToDiscount = promotion.amountToDiscount(100, 7);

        Assert.assertEquals(200, amountToDiscount);
    }


    @Test
    public void shouldGetZeroDiscountWhenTotalProductIsNotEnoughToPromotion() {
        ComboProductPromotion promotion = new ComboProductPromotion(3, 200);

        int amountToDiscount = promotion.amountToDiscount(100, 2);

        Assert.assertEquals(0, amountToDiscount);
    }

    @Test
    public void shouldGetZeroDiscountWhenTotalProductIsZero() {
        ComboProductPromotion promotion = new ComboProductPromotion(3, 200);

        int amountToDiscount = promotion.amountToDiscount(100, 2);

        Assert.assertEquals(0, amountToDiscount);
    }
}
