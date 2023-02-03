package com.springbootfeatures.controller;

import com.springbootfeatures.model.Book;
import com.springbootfeatures.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/{bookId}"})
    public ResponseEntity<?> getBookById(@PathVariable("bookId") Long bookId) {

        return new ResponseEntity<>(bookService.findById(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@RequestBody Book book) {

        Book saved = bookService.saveBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/book/" + saved.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{bookId}"})
    public ResponseEntity<?> handleUpdate(@PathVariable("bookId") Long bookId, @RequestBody Book book) {

        bookService.updateBook(bookId, book);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{bookId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("bookId") Long bookId) {

        bookService.deleteById(bookId);
    }
}
