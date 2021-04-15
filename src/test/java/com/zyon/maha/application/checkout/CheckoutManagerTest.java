package com.zyon.maha.application.checkout;

import com.zyon.maha.infrastructure.database.ProductMemoryDB;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutManagerTest {

    private ProductMemoryDB productMemoryDB = new ProductMemoryDB();

    @Test
    public void shouldCalculateTotalOrder() {

        CheckoutManager checkoutManager = new CheckoutManager(productMemoryDB);
        String[] productsId = {"001", "001", "001", "002", "002"};

        ResponseVO response = checkoutManager.process(productsId);

        Assert.assertEquals(320, response.getPrice());
    }

    @Test
    public void shouldCaclulateTotalIgnoringWrongsProductsIds() {
        CheckoutManager checkoutManager = new CheckoutManager(productMemoryDB);
        String[] productsId = {"001", "001","zzz", "001", "002", "","002", "002","nnnd33", "002", "002"};

        ResponseVO response = checkoutManager.process(productsId);

        Assert.assertEquals(520, response.getPrice());
    }
}
