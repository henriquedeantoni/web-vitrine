package com.demo.vitrine.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product {

    DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String urlImage;

    public Product(){
    }

    public Product(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Product(Long id, String name, String description, BigDecimal price, String urlImage){
        this.id = id;
        this.name=name;
        this.description=description;
        this.price = price;
        this.urlImage = urlImage;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id=id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString(){
        return "Informações Produto: " +
            "Id: " + id.toString() +
            "Name: " + name.toString() +
            "Description: " + description.toString() +
            "Price: " + decimalFormat.format(price) +
            "Image URL: " + urlImage;            
    }
}
