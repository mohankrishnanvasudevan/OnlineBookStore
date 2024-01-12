package com.test.library.exception;

public class ResourceNotFoundExecption extends RuntimeException {
	public ResourceNotFoundExecption() {
		super();
	}

	public ResourceNotFoundExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundExecption(String message) {
		super(message);
	}

	public ResourceNotFoundExecption(Throwable cause) {
		super(cause);
	}
}
