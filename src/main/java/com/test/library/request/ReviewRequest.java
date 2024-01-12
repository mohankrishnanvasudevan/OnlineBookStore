package com.test.library.request;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewRequest {
	

	private int rating;

	private String comments;

	private Date reviewDate;

	private String userName;

}
