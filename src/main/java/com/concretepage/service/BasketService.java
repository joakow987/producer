package com.concretepage.service;

import com.concretepage.gs_ws.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private List<Product> productList = new ArrayList<>();


    public List<Product> getBasket() {
        return productList;

    }

    public void addToBasket(Product product){
        productList.add(product);
    }

    public void deleteFromBasket(Product product){
        productList.remove(product);
    }
}
