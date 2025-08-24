package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.application.usecases.CategoryUseCases;
import com.pragma.tournament.domain.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api/v1/categories")
public class CategoryController {
    private final CategoryUseCases categoryUseCases;

    public CategoryController(CategoryUseCases categoryUseCases) {
        this.categoryUseCases = categoryUseCases;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
        categoryUseCases.createCategory(category);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories() {
        return categoryUseCases.getAllCategories();
    }
}