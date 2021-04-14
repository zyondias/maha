package com.zyon.maha.controller;

import com.zyon.maha.application.checkout.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CheckoutController {

    @PostMapping("/checkout")
    public ResponseVO checkout(@RequestBody String[] ids) {

        Arrays.stream(ids).forEach(System.out::println);
        return new ResponseVO(100);
    }
}
