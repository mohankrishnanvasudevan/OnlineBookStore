package com.techconative.library.respository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techconative.library.entity.BookEntity;
import com.techconative.library.exception.ResourceNotFoundExecption;
import com.techconative.library.respository.BookRespository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class BookRepositoryImpl implements BookRespository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BookEntity> findAll(String title, String genre) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<BookEntity> cr = cb.createQuery(BookEntity.class);
		Root<BookEntity> book = cr.from(BookEntity.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.isNotEmpty(title))
			predicates.add(cb.like(book.get("title"), title));
		if (StringUtils.isNotEmpty(genre))
			predicates.add(cb.like(book.get("genre"), genre));
		cr.select(book).where(predicates.toArray(new Predicate[0]));

		return entityManager.createQuery(cr).getResultList();
	}

	@Override
	public BookEntity getByISBN(String isbn) {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<BookEntity> cr = cb.createQuery(BookEntity.class);
			Root<BookEntity> book = cr.from(BookEntity.class);
			cr.select(book).where(cb.equal(book.get("isbn"), isbn));
			return entityManager.createQuery(cr).getSingleResult();
		} catch (NoResultException e) {
			throw new ResourceNotFoundExecption("No book found for the given ISBN");
		}
		
	}

	@Override
	@Transactional
	public void deleteByISBN(String isbn) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<BookEntity> cr = cb.createCriteriaDelete(BookEntity.class);
		Root<BookEntity> book = cr.from(BookEntity.class);
		cr.where(cb.equal(book.get("isbn"), isbn));
		int records =  entityManager.createQuery(cr).executeUpdate();
		if(records == 0) {
			throw new ResourceNotFoundExecption("No book found for the given ISBN");
		}

	}

	@Override
	@Transactional
	public void saveEntity(BookEntity entity) {
		entityManager.merge(entity);
		
	}

}
