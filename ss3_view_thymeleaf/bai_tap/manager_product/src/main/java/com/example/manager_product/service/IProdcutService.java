package com.example.manager_product.service;


import com.example.manager_product.model.Product;

import java.util.List;

public interface IProdcutService {
    List<Product> getAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);
    List<Product> findByName(String name);
    void delete(int id);
//    List<Product> findByName(String name);
}
