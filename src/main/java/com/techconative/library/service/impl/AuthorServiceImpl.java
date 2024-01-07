package com.techconative.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techconative.library.entity.AuthorEntity;
import com.techconative.library.respository.AuthorRespository;
import com.techconative.library.service.AuthorService;

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
