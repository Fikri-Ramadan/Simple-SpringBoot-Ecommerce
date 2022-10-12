package com.fikritech.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fikritech.ecommerce.common.BaseController;
import com.fikritech.ecommerce.common.BaseResponse;
import com.fikritech.ecommerce.entity.Category;
import com.fikritech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Category>> getOne(@PathVariable Long id) {
            return ResponseEntity.ok(new BaseResponse<>(categoryService.getOne(id)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Category>>> getAll() {
        return ResponseEntity.ok(new BaseResponse<>(categoryService.getAll()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Category>> addOne(@RequestBody Category category) {
        return ResponseEntity.ok(new BaseResponse<>(categoryService.addOne(category)));
    }

}
