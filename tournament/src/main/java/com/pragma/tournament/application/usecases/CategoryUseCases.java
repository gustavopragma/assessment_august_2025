package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.models.Category;
import com.pragma.tournament.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryUseCases {
    private final CategoryRepository categoryRepository;

    public CategoryUseCases(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(Category category) {
        Optional<Category> previousCategory = categoryRepository.getCategoryById(category.getId());
        if(previousCategory.isPresent()) throw new AlreadyExistsException("Category with ID " + category.getId() + " already exists");
        categoryRepository.createCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}