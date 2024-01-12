package com.test.library.service;

import com.test.library.request.BookRequest;
import com.test.library.request.ReviewRequest;

public interface ReviewService {

	public void addReview(String isbn, ReviewRequest request);
}
