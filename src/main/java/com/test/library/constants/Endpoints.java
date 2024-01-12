package com.test.library.constants;

public final class Endpoints {

	public final static String GET_AUTHOR_BY_AUTHOR_ID = "/api/authors/{authorId}";
	public final static String GET_ALL_BOOKS = "/api/books";
	public final static String BOOK_BY_ISBN = "/api/books/{isbn}";
	public final static String REVIEW_BY_ISBN = "/api/books/{isbn}/reviews";
	public final static String ADD_BOOK = "/api/books";

	private Endpoints() {
	    
	}

}
