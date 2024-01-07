package com.techconative.library.respository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techconative.library.entity.ReviewEntity;
import com.techconative.library.respository.ReviewRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void saveEntity(ReviewEntity entity) {
		entityManager.merge(entity);

	}


}
