package com.demo.vitrine.service;
import org.springframework.stereotype.Service;

import com.demo.vitrine.model.Product;
import java.util.List;
import java.util.ArrayList;

@Service
public class CatalogService {

    private List<Product> products = new ArrayList<>();
    private long proximoId = 1L;
    public CatalogService(){}

    public void registerProduct(Product product){

    }
}
