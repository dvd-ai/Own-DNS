package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**v1*/
@Repository
public interface ReviewRepo extends JpaRepository<Reviews, Long> {
    Optional<Reviews> findReviewsById(Long id);
}
