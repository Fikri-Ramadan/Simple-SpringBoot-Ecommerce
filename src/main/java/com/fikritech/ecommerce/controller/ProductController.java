package com.fikritech.ecommerce.controller;

import com.fikritech.ecommerce.common.BaseResponse;
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
    public ResponseEntity<BaseResponse<Product>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(new BaseResponse<>(productService.getOne(id)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Product>>> getAll() {
        return ResponseEntity.ok(new BaseResponse<>(productService.getAll()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Product>> addOne(@RequestBody Product product) {
        return ResponseEntity.ok(new BaseResponse<>(productService.addOne(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Product>> updateOne(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(new BaseResponse<>(productService.updateOne(id, product)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Boolean>> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(new BaseResponse<>(productService.deleteOne(id)));
    }

}
