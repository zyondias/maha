package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;
import org.junit.Assert;
import org.junit.Test;

public class CountProductTest {

    private ProductVO rolex = new ProductVO("001", "Rolex", 100, null);
    private ProductVO dummont = new ProductVO("002", "Dummont", 200, null);

    @Test
    public void shouldReturnTheRightCountToProducts() {
        CountProduct countProduct = new CountProduct();

        countProduct.addProduct(rolex);
        countProduct.addProduct(dummont);
        countProduct.addProduct(rolex);
        int rolexCount = countProduct.getProducts().get(rolex);
        int dummontCount = countProduct.getProducts().get(dummont);

        Assert.assertEquals(2, rolexCount);
        Assert.assertEquals(1, dummontCount);
    }

    @Test
    public void shouldReturnEmptyMapWhenIDoNotAddAnyProduct() {
        CountProduct countProduct = new CountProduct();

        Assert.assertNotNull(countProduct.getProducts());
    }
}
