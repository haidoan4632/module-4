package com.example.manager_product.configuration.repository.impl;

import com.example.manager_product.configuration.model.Product;
import com.example.manager_product.configuration.repository.IProductRepository;;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"a","10000","a","a"));
        productList.put(2,new Product(2,"b","15000","b","b"));
        productList.put(3,new Product(3,"c","20000","c","c"));
        productList.put(4,new Product(4,"d","50000","d","d"));
    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productList.values()) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}