package com.test.library.respository;

import java.util.List;

import com.test.library.entity.BookEntity;

public interface BookRespository {
	
	List<BookEntity> findAll(String title, String genre);
	
	void saveEntity(BookEntity entity);
	
	BookEntity getByISBN(String isbn);
	
	void deleteByISBN(String isbn);

}
