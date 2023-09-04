package com.example.store.Repository;

import com.example.store.Entity.Review;
import com.example.store.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStore(Store store);
}