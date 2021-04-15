package com.zyon.maha.application.checkout.logic;

import com.zyon.maha.application.product.ProductVO;
import org.junit.Assert;
import org.junit.Test;

public class CountTest {

    private ProductVO rolex = new ProductVO("001", "Rolex", 100, null);
    private ProductVO dummont = new ProductVO("002", "Dummont", 200, null);

    @Test
    public void shouldReturnTheRightCountToProducts() {
        Count count = new Count();

        count.addProduct(rolex);
        count.addProduct(dummont);
        count.addProduct(rolex);
        int rolexCount = count.getProductQuantity().get(rolex);
        int dummontCount = count.getProductQuantity().get(dummont);

        Assert.assertEquals(2, rolexCount);
        Assert.assertEquals(1, dummontCount);
    }

    @Test
    public void shouldReturnEmptyMapWhenIDoNotAddAnyProduct() {
        Count count = new Count();

        Assert.assertNotNull(count.getProductQuantity());
    }

    @Test
    public void shouldIgnoreNullValues(){
        Count count = new Count();

        count.addProduct(rolex);
        count.addProduct(null);
        count.addProduct(dummont);
        count.addProduct(rolex);

        int rolexCount = count.getProductQuantity().get(rolex);
        int dummontCount = count.getProductQuantity().get(dummont);

        Assert.assertEquals(2, rolexCount);
        Assert.assertEquals(1, dummontCount);
        Assert.assertNull(count.getProductQuantity().get(null));
    }
}
