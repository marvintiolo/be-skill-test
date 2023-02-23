package com.crescendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crescendo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
