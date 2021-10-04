package com.epam.shop.smoke.service;

import com.epam.shop.smoke.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getListCategories();
    Category getCategoryById(Long id);
}
