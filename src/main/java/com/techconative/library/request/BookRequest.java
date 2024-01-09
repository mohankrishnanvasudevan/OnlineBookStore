package com.techconative.library.request;

import java.sql.Date;

import lombok.Data;

@Data
public class BookRequest {

	public BookRequest(String title, Date publicationDate, String genre, String otherBookDetails) {
		super();
		this.title = title;
		this.publicationDate = publicationDate;
		this.genre = genre;
		this.otherBookDetails = otherBookDetails;
	}
	
	public BookRequest() {
		
	}

	private String title;

	private Date publicationDate;

	private String isbn;

	private String genre;

	private String otherBookDetails;
}
