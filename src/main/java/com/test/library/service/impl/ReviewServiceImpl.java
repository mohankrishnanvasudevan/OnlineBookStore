package com.test.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.library.entity.ReviewEntity;
import com.test.library.exception.ResourceNotFoundExecption;
import com.test.library.request.ReviewRequest;
import com.test.library.respository.BookRespository;
import com.test.library.respository.ReviewRepository;
import com.test.library.service.ReviewService;
import com.test.library.util.CommonUtil;

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
