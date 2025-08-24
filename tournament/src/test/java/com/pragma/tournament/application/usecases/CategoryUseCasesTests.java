package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.models.Category;
import com.pragma.tournament.domain.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryUseCasesTests {

    private Category category;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryUseCases categoryUseCases;

    @BeforeEach
    public void setUp() {
        category = new Category();
        category.setId("123");
        category.setFree(true);
        category.setName("Category 1");
        category.setMaxSpectators(10);
        category.setMaxParticipants(4);
    }

    @Test
    public void testCreateCategory() {
        doNothing().when(categoryRepository).createCategory(category);
        categoryUseCases.createCategory(category);
        verify(categoryRepository, times(1)).createCategory(category);
    }

    @Test
    public void testCreateCategoryAlreadyExists() {
        when(categoryRepository.getCategoryById(category.getId())).thenReturn(Optional.of(category));
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            categoryUseCases.createCategory(category);
        });
        verify(categoryRepository, times(1)).getCategoryById(category.getId());
    }

    @Test
    public void testGetAllCategories() {
        when(categoryRepository.getAllCategories()).thenReturn(List.of(category));
        categoryUseCases.getAllCategories();
        verify(categoryRepository, times(1)).getAllCategories();
    }
}