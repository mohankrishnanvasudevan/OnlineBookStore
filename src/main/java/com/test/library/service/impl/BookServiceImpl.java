package com.test.library.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.library.entity.BookEntity;
import com.test.library.exception.ResourceNotFoundExecption;
import com.test.library.exception.ValidationException;
import com.test.library.request.BookRequest;
import com.test.library.respository.BookRespository;
import com.test.library.service.BookService;
import com.test.library.util.CommonUtil;

import jakarta.persistence.NoResultException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRespository bookRespository;

	@Override
	public List<BookEntity> findAllBooks(String title, String genre) {

		List<BookEntity> books = bookRespository.findAll(title, genre);
		return books;
	}

	@Override
	public void addBook(BookRequest book) {

		try {
			BookEntity entity = new ModelMapper().map(book, BookEntity.class);
			bookRespository.saveEntity(entity);
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Override
	public BookEntity getBookByISBN(String isbn) {
		try {
			BookEntity book = bookRespository.getByISBN(isbn);
			return book;
		} catch (NoResultException e) {
			log.info("dmclneb");
			throw new ResourceNotFoundExecption("No book found for the given ISBN");
		}
		
		
	}

	@Override
	public void deleteBookByISBN(String isbn) {
		bookRespository.deleteByISBN(isbn);
	}

	@Override
	public BookEntity updateBookByISBN(String isbn, BookRequest book) {
		BookEntity bookEntity = getBookByISBN(isbn);
		CommonUtil.mapNonNullProperties(book, bookEntity);
		bookRespository.saveEntity(bookEntity);
		return bookEntity;
	}

}
