package com.demo.vitrine.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.demo.vitrine.model.Product;
import com.demo.vitrine.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import org.springframework.ui.Model;


@Controller
public class CatalogController {
    @Autowired
    private CatalogService service;

    @GetMapping("/")
    public String listProducts(@RequestParam(required = false) String term, Model model) {
        System.out.println("iniciado controller");
        List<Product> productsList;
        if(term != null && !term.isEmpty()){
            System.out.println("consulta service");
            productsList = service.findByName(term);
        } else {
            productsList = service.findAll();
        }
        model.addAttribute("products", productsList);
        model.addAttribute("term", term);

        return "catalog";
    }
    
}
