package com.pragma.tournament.infrastructure.mappers;

import com.pragma.tournament.domain.models.Category;
import com.pragma.tournament.infrastructure.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryEntity, Category>{
    @Override
    public CategoryEntity toEntity(Category model) {
        return CategoryEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .maxParticipants(model.getMaxParticipants())
                .maxSpectators(model.getMaxSpectators())
                .free(model.getFree())
                .build();
    }

    @Override
    public Category toModel(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setMaxParticipants(entity.getMaxParticipants());
        category.setMaxSpectators(entity.getMaxSpectators());
        category.setFree(entity.getFree());
        return category;
    }
}