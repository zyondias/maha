package com.zyon.maha.application.checkout;

import com.zyon.maha.application.checkout.logic.Calculate;
import com.zyon.maha.application.checkout.logic.Count;
import com.zyon.maha.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CheckoutManager {

    private ProductModel productModel;

    @Autowired
    public CheckoutManager(ProductModel productModel) {
        this.productModel = productModel;
    }

    public ResponseVO process(String[] productsIds){
        Count count = new Count();

        Arrays.stream(productsIds)
                .map(productId -> productModel.findById(productId))
                .forEach(count::addProduct);

        int totalPrice = Calculate.total(count.getProductQuantity());

        return new ResponseVO(totalPrice);
    }
}
