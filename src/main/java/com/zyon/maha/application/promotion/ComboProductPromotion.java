package com.zyon.maha.application.promotion;

public class ComboProductPromotion implements Promotion {

    private int conditionToDiscount;
    private int specialPrice;

    public ComboProductPromotion(int conditionToDiscount, int specialPrice) {
        this.conditionToDiscount = conditionToDiscount;
        this.specialPrice = specialPrice;
    }

    @Override
    public int amountToDiscount(int regularPrice, int quantityProduct) {
        int totalRegularPrice = regularPrice * quantityProduct;

        int quantityDiscountAvailable = quantityProduct / conditionToDiscount;

        int totalPriceDiscountProducts = specialPrice * quantityDiscountAvailable;

        int productWithoutDiscount = quantityProduct - (conditionToDiscount * quantityDiscountAvailable);

        int totalPrice = (productWithoutDiscount * regularPrice) + totalPriceDiscountProducts;

        return totalRegularPrice - totalPrice;
    }
}
