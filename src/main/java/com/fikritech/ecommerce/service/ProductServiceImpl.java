package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Category;
import com.fikritech.ecommerce.entity.Product;
import com.fikritech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Product getOne(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return optional.get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addOne(Product product) {
        Category category = categoryService.getOne(product.getCategory().getId());

        Product productTemp = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(category)
                .build();

        productRepository.save(productTemp);

        return productTemp;
    }

    @Override
    public Product updateOne(Long id, Product product) {
        return null;
    }

    @Override
    public Boolean deleteOne(Long id) {
        return null;
    }

}
