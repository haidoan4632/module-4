package com.example.manager_product.repository;

import com.example.manager_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void save(Product product);

    Product findById(int id);
    List<Product> findByName(String name);

    void update(int id, Product product);

    void delete(int id);
//    List<Product> findByName(String name);
}
