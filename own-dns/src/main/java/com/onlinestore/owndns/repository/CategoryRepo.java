package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**v1*/

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);
}
