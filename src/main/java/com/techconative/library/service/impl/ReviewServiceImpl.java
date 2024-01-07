package com.techconative.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techconative.library.config.util.CommonUtil;
import com.techconative.library.entity.ReviewEntity;
import com.techconative.library.exception.ResourceNotFoundExecption;
import com.techconative.library.request.ReviewRequest;
import com.techconative.library.respository.BookRespository;
import com.techconative.library.respository.ReviewRepository;
import com.techconative.library.service.ReviewService;

import jakarta.persistence.NoResultException;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private BookRespository bookRespository;

	@Override
	public void addReview(String isbn, ReviewRequest request) {
		try {
			bookRespository.getByISBN(isbn);
			ReviewEntity reviewEntity = CommonUtil.mapNonNullProperties(request, ReviewEntity.class);
			reviewEntity.setIsbn(isbn);
			reviewRepository.saveEntity(reviewEntity);
		} catch (NoResultException e) {
			throw new ResourceNotFoundExecption("No book found for the given ISBN");
		}
	}

}
