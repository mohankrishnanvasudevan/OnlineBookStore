package com.techconative.library.service;

import com.techconative.library.request.BookRequest;
import com.techconative.library.request.ReviewRequest;

public interface ReviewService {

	public void addReview(String isbn, ReviewRequest request);
}
