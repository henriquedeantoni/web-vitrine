package com.demo.vitrine.service;
import org.springframework.stereotype.Service;

import com.demo.vitrine.model.Product;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

@Service
public class CatalogService {

    private List<Product> products = new ArrayList<>();
    private long nextId = 1L;
    public CatalogService(){}

    public void registerProduct(Product product){
        if(product.getId() == null){
            product.setId(nextId++);
            products.add(product);
        }
        else
        {
            delete(product.getId());
            products.add(product);
        }
    }

    public List<Product> findAll(){
        System.out.println("iniciando metodo find all");
        return products;
    }

    public Product findById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Product> findByName(String term){
        if(term==null || term.trim().isEmpty()){
            return products;
        }
        String lowerCaseTerm = term.toLowerCase();
        return products.stream().filter(p -> p.getName().toLowerCase().contains(lowerCaseTerm)).collect(Collectors.toList());
    }

    public void delete(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }
}
