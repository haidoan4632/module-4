package com.example.manager_product.repository.impl;

import com.example.manager_product.model.Product;
import com.example.manager_product.repository.ConnectionUtils;
import com.example.manager_product.repository.IProductRepository;;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCTS_QUERY ="FROM Product";
    @Override
    public List<Product> getAll() {
        return ConnectionUtils.getEntityManager().createNamedQuery(SELECT_ALL_PRODUCTS_QUERY).getResultList();
    }


//    @Override
//    public void save(Product product) {
//        productList.put(product.getId(),product);
//    }
//
//    @Override
//    public Product findById(int id) {
//        return productList.get(id);
//    }
//
//    @Override
//    public void update(int id, Product product) {
//        productList.put(id, product);
//    }
//
//    @Override
//    public void delete(int id) {
//        productList.remove(id);
//    }
//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Product product : productList.values()) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
//        return products;
//    }
}