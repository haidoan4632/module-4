package com.example.gio_hang.repository;

import com.example.gio_hang.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {

}
