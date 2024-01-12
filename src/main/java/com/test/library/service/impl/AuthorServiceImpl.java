package com.test.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.library.entity.AuthorEntity;
import com.test.library.respository.AuthorRespository;
import com.test.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRespository authorRespository;

	@Override
	public AuthorEntity getAuthorByAuthorID(Long authorId) {
		AuthorEntity author = authorRespository.getByAuthorId(authorId);
		return author;
	}
	
	

}
