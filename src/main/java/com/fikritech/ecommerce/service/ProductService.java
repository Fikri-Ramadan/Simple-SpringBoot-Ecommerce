package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    Product getOne(Long id);

    List<Product> getAll();

    Product addOne(Product product);

    Product updateOne(Long id, Product product);

    Boolean deleteOne(Long id);

}
