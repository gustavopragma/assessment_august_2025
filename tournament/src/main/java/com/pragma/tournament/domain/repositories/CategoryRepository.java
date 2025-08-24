package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    void createCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(String id);
}