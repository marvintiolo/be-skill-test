package com.crescendo.service;

import java.util.List;

import com.crescendo.model.Review;

public interface IReviewService {
	public List<Review> getAllReviewByBusinessId(int businessId);
	public Review addReviewByBusinessId(int businessId, Review review);
}
