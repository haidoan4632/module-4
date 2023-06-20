package com.example.manager_product.configuration.service;


import com.example.manager_product.configuration.model.Product;

import java.util.List;

public interface IProdcutService {
    List<Product> getAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);
    List<Product> findByName(String name);
}
