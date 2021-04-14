package com.zyon.maha.infrastructure.database;

import com.zyon.maha.application.product.ProductVO;
import com.zyon.maha.model.ProductModel;

import java.util.HashMap;
import java.util.Map;

public class ProductMemoryDB implements ProductModel {

    private Map<String, ProductVO> products;

    public ProductMemoryDB (){
        this.products = new HashMap<>();
        this.products.put("001", new ProductVO("001", "Rolex", 100, null));
        this.products.put("002", new ProductVO("001", "Michael Kors", 80, null));
        this.products.put("003", new ProductVO("001", "Swatch", 50, null));
        this.products.put("004", new ProductVO("001", "Casio", 30, null));
    }


    @Override
    public ProductVO findById(String id) {
        return this.products.get(id);
    }
}
