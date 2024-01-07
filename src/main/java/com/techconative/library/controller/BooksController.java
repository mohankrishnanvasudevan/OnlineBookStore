package com.techconative.library.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techconative.library.constants.Endpoints;
import com.techconative.library.entity.AuthorEntity;
import com.techconative.library.entity.BookEntity;
import com.techconative.library.request.BookRequest;
import com.techconative.library.request.ReviewRequest;
import com.techconative.library.service.AuthorService;
import com.techconative.library.service.BookService;
import com.techconative.library.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class BooksController<T> {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private AuthorService authorService;
	

	@Operation(summary = "Retrieve all books with filters for searching.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success", content = {}),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@GetMapping(path = Endpoints.GET_ALL_BOOKS)
	public List<BookEntity> getALLBooks(@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "author", required = false) String author) {
		long start = System.currentTimeMillis();
		List<BookEntity> books = bookService.findAllBooks(title, author);
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return books;
	}

	@Operation(summary = "Add a new book to the inventory.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "400", description = "BadRequest") })
	@PostMapping(path = Endpoints.ADD_BOOK)
	public ResponseEntity<T> createBook(@RequestBody BookRequest book) {
		long start = System.currentTimeMillis();
		bookService.addBook(book);
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}

	@Operation(summary = "Retrieve details for a specific book by ISBN.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@GetMapping(path = Endpoints.BOOK_BY_ISBN)
	public BookEntity getBookByISBN(@PathVariable String isbn) {
		long start = System.currentTimeMillis();
		BookEntity book = bookService.getBookByISBN(isbn);
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return book;
	}
	
	@Operation(summary = "Update details of a book by ISBN.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@PutMapping(path = Endpoints.BOOK_BY_ISBN)
	public ResponseEntity<BookEntity> updateBookByISBN(@PathVariable String isbn, @RequestParam(required = false) String title, @RequestParam(required = false) Date publicationDate, @RequestParam(required = false) String genre, @RequestParam(required = false) String otherBookDetails ) {
		long start = System.currentTimeMillis();
		BookEntity bookEntity = bookService.updateBookByISBN(isbn, new BookRequest(title, publicationDate, genre, otherBookDetails));
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return new ResponseEntity<BookEntity>(bookEntity, HttpStatusCode.valueOf(200));
	}
	
	

	@Operation(summary = "Remove a book from the inventory by ISBN.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@DeleteMapping(path = Endpoints.BOOK_BY_ISBN)
	public ResponseEntity<String> deleteBookByISBN(@PathVariable String isbn) {
		long start = System.currentTimeMillis();
		bookService.deleteBookByISBN(isbn);
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return new ResponseEntity<>("Book Removed",  HttpStatusCode.valueOf(200));
	}
	
	@Operation(summary = "Submit a review for a book.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@PostMapping(path = Endpoints.REVIEW_BY_ISBN)
	public ResponseEntity<T> addReviewByISBN(@PathVariable String isbn, @RequestBody ReviewRequest reviewRequest) {
		long start = System.currentTimeMillis();
		reviewService.addReview(isbn, reviewRequest);
		log.info("Total Consumed Time for getALLBooks is :" + (System.currentTimeMillis() - start) + " ms");
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@Operation(summary = "Retrieve details for a specific author.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Not found") })
	@GetMapping(path = Endpoints.GET_AUTHOR_BY_AUTHOR_ID)
	public AuthorEntity getAuthorByAuthorId(@PathVariable Long authorId) {
		long start = System.currentTimeMillis();
		AuthorEntity author = authorService.getAuthorByAuthorID(authorId);
		log.info("Total Consumed Time for getAuthorByAuthorId is :"+(System.currentTimeMillis()-start)+" ms");
		return author;
	}
	

}