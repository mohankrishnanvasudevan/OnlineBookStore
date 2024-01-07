package com.techconative.library.respository;

import java.util.List;

import com.techconative.library.entity.BookEntity;

public interface BookRespository {
	
	List<BookEntity> findAll(String title, String Author);
	
	void saveEntity(BookEntity entity);
	
	BookEntity getByISBN(String isbn);
	
	void deleteByISBN(String isbn);

}
