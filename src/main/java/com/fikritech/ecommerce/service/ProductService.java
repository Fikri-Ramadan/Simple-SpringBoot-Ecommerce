package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    public Product getOne(Long id);

    public List<Product> getAll();

    public Product addOne(Product product);

    public Product updateOne(Long id, Product product);

    public Boolean deleteOne(Long id);

}
