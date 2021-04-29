package com.mucahit.recipeapp.repositories;

import com.mucahit.recipeapp.domain.Category;
import com.mucahit.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
