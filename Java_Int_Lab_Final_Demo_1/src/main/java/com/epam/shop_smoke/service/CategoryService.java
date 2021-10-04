package com.epam.shop_smoke.service;

import com.epam.shop_smoke.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getListCategories();
    Category getCategoryById(Long id);
}
