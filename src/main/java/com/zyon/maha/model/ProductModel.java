package com.zyon.maha.model;

import com.zyon.maha.application.product.ProductVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModel {

    ProductVO findById(String id);
}
