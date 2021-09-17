package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.ReviewNotFoundException;
import com.onlinestore.owndns.model.Reviews;
import com.onlinestore.owndns.repository.ReviewRepo;
import org.springframework.stereotype.Service;


/**v1*/
@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public Reviews addReview(Reviews review) {
        return reviewRepo.save(review);
    }

    public void deleteReviewById(Long id) {
        reviewRepo.deleteById(id);
    }

    public Reviews updateReview(Reviews reviews) {
        return reviewRepo.save(reviews);
    }

    public Reviews findReviewById(Long id) {
        return reviewRepo.findReviewsById(id).orElseThrow(
                () -> new ReviewNotFoundException(getClass().getSimpleName() + " Review with id " + id + " not found"));
    }
}
