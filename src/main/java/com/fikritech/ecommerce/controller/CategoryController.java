package com.fikritech.ecommerce.controller;

import com.fikritech.ecommerce.entity.Category;
import com.fikritech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Category getOne(@PathVariable Long id) {

        return categoryService.getOne(id);

    }

    @GetMapping
    public List<Category> getAll() {

        return categoryService.getAll();

    }

    @PostMapping
    public Category addOne(@RequestBody Category category) {

        return categoryService.addOne(category);

    }

}
