package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.domain.models.Category;
import com.pragma.tournament.domain.repositories.CategoryRepository;
import com.pragma.tournament.infrastructure.entities.CategoryEntity;
import com.pragma.tournament.infrastructure.mappers.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryMapper categoryMapper;
    private final PostgresCategoryRepository postgresCategoryRepository;

    public CategoryRepositoryImpl(CategoryMapper categoryMapper, PostgresCategoryRepository postgresCategoryRepository) {
        this.categoryMapper = categoryMapper;
        this.postgresCategoryRepository = postgresCategoryRepository;
    }

    @Override
    public void createCategory(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        postgresCategoryRepository.save(categoryEntity);
    }

    @Override
    public List<Category> getAllCategories() {
        return postgresCategoryRepository.findAll()
                .stream()
                .map(categoryMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return postgresCategoryRepository.findById(id).map(categoryMapper::toModel);
    }
}