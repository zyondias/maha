package com.zyon.maha.infrastructure.database;

import com.zyon.maha.application.product.ProductVO;
import com.zyon.maha.application.promotion.ComboProductPromotion;
import com.zyon.maha.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductMemoryDB implements ProductModel {

    private Map<String, ProductVO> products;

    public ProductMemoryDB (){
        this.products = new HashMap<>();
        this.products.put("001", new ProductVO("001", "Rolex", 100, new ComboProductPromotion(3,200)));
        this.products.put("002", new ProductVO("002", "Michael Kors", 80, new ComboProductPromotion(2, 120)));
        this.products.put("003", new ProductVO("003", "Swatch", 50, null));
        this.products.put("004", new ProductVO("004", "Casio", 30, null));
    }


    @Override
    public ProductVO findById(String id) {
        return this.products.get(id);
    }
}
