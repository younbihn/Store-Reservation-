package com.example.store.Service;

import com.example.store.Entity.Review;
import com.example.store.Entity.Store;
import com.example.store.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByStore(Store store) {
        return reviewRepository.findByStore(store);
    }

    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}