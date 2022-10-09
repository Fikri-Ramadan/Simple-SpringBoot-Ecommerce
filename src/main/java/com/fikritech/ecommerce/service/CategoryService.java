package com.fikritech.ecommerce.service;

import com.fikritech.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {

	public Category getOne(Long id);
	public List<Category> getAll();
	public Category addOne(Category category);

}
