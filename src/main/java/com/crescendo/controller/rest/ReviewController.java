package com.crescendo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.model.Review;
import com.crescendo.service.IReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {
	@Autowired
	IReviewService reviewService;
	
	@GetMapping("/businesses/{businessId}/reviews")
	public ResponseEntity<List<Review>> getAllReviewByBusinessId(@PathVariable int businessId) {
		return new ResponseEntity<>(
				reviewService.getAllReviewByBusinessId(businessId), HttpStatus.OK);
	}
	
	@PostMapping("/businesses/{businessId}/reviews")
	public ResponseEntity<Review> createReviewByBusinessId(@PathVariable int businessId, @RequestBody Review review) {
		return new ResponseEntity<>(
				reviewService.addReviewByBusinessId(businessId, review), HttpStatus.CREATED);
	}
	
	@PutMapping("/businesses/reviews/{reviewId}")
	public ResponseEntity<Review> updateReviewById(@PathVariable int reviewId, @RequestBody Review review) {
		return new ResponseEntity<>(reviewService.updateReviewById(reviewId, review), HttpStatus.CREATED);
	}
}
