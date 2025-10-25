package com.demo.vitrine.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.demo.vitrine.model.Product;
import com.demo.vitrine.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CatalogController {
    @Autowired
    private CatalogService service;

    @GetMapping("/")
    public String listProducts(@RequestParam(required = false) String term, Model model) {
        List<Product> productsList;
        if(term != null && !term.isEmpty()){
            productsList = service.findByName(term);
        } else {
            productsList = service.findAll();
        }
        model.addAttribute("products", productsList);
        model.addAttribute("term", term);

        return "catalog";
    }

    @GetMapping("/produto/{id}")
    public String detailProduct(
        @PathVariable Long id,
        Model model) {
        Product product = service.findById(id);
        if(product == null)
        {
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/cadastro")
    public String showRegisterForm(
        Model model
    ){
        model.addAttribute("product", new Product());
        return "register";
    }

    @GetMapping("/produto/editar/{id}")
    public String showEditForm(
        @PathVariable Long id, 
        Model model) {
        Product product = service.findById(id);
        if(product == null){
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String saveProduct(Product product) {
        service.registerProduct(product);
        return "redirect:/";
    }

    @PostMapping("/produto/excluir/{id}")
    public String deleteProduct(
        @PathVariable Long id
    ){
        service.delete(id);
        return "redirect:/";
    }
}
