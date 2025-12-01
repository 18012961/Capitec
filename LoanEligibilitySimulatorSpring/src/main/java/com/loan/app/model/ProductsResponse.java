package com.loan.app.model;

import java.util.List;

public class ProductsResponse {
    private List<Product> products;
    public List<Product> getProducts(){return products;} public void setProducts(List<Product> p){this.products=p;}
}
