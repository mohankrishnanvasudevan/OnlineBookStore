package com.techconative.library.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int status;
	
	private String error;
	
	private String message;
	
	private Timestamp timestamp;

}
