package com.fikritech.ecommerce.controller;

import com.fikritech.ecommerce.entity.Product;
import com.fikritech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Component
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product addOne(@RequestBody Product product) {
        return productService.addOne(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateOne(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateOne(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteOne(id));
    }

}
