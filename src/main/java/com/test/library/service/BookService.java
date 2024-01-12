package com.test.library.service;

import java.util.List;

import com.test.library.entity.BookEntity;
import com.test.library.request.BookRequest;

public interface BookService {
	
	public List<BookEntity> findAllBooks(String title, String genre);
	
	public void addBook(BookRequest book);
	
	public BookEntity getBookByISBN(String isbn);
	
	public void deleteBookByISBN(String isbn);
	
	public BookEntity updateBookByISBN(String isbn, BookRequest book);

}
