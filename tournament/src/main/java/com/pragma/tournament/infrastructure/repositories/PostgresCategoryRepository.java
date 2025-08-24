package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresCategoryRepository extends JpaRepository<CategoryEntity, String> {
}