package com.test.library.respository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.library.entity.ReviewEntity;
import com.test.library.respository.ReviewRepository;

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
