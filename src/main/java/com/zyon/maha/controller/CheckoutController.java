package com.zyon.maha.controller;

import com.zyon.maha.application.checkout.CheckoutManager;
import com.zyon.maha.application.checkout.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

    @Autowired
    private CheckoutManager checkoutManager;

    @PostMapping("/checkout")
    public ResponseVO checkout(@RequestBody String[] productsIds) {
        return checkoutManager.process(productsIds);
    }
}
