package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Category;
import com.fikritech.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getOne(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        return optional.get();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addOne(Category category) {
        Category categoryTemp = Category.builder()
                .name(category.getName())
                .build();

        categoryRepository.save(categoryTemp);

        return categoryTemp;
    }
}
