package com.crescendo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.exception.ResourceNotFoundException;
import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {
	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	BusinessRepository businessRepository;

	@Override
	public List<Review> getAllReviewByBusinessId(int businessId) {
		Business business = businessRepository.findById(businessId)
				.orElseThrow(() -> new ResourceNotFoundException("Business ID Not found = " + businessId));

		List<Review> reviews = new ArrayList<>();
		reviews.addAll(business.getReviews());
		return reviews;
	}

	@Override
	public Review addReviewByBusinessId(int businessId, Review reviewRequest) {
		return businessRepository.findById(businessId).map(business -> {
			business.getReviews().add(reviewRequest);
			return reviewRepository.save(reviewRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Business ID Not found = " + businessId));
	}

	@Override
	public Review updateReviewById(int reviewId, Review review) {
		Review updateReview = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review ID Not found = " + reviewId));
		updateReview.setText(review.getText());
		updateReview.setRating(review.getRating());
		updateReview.setCreatedDateTime(review.getCreatedDateTime());
		return reviewRepository.save(updateReview);
	}

}
