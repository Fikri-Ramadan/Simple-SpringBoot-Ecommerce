package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Category;
import com.fikritech.ecommerce.entity.Product;
import com.fikritech.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
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
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        Product productTemp = optional.get();

        if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            productTemp.setName(product.getName());
        }

        if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
            productTemp.setDescription(product.getDescription());
        }

        if (Objects.nonNull(product.getPrice()) && product.getPrice() != 0) {
            productTemp.setPrice(product.getPrice());
        }

        if (Objects.nonNull(product.getCategory()) && product.getCategory().getId() != 0) {
            Category category = categoryService.getOne(product.getCategory().getId());
            productTemp.setCategory(category);
        }

        productRepository.save(productTemp);

        return productTemp;
    }

    @Override
    public Boolean deleteOne(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
