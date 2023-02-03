package com.springbootfeatures.service.impl;

import com.springbootfeatures.aspect.annotation.MyTimer;
import com.springbootfeatures.model.Book;
import com.springbootfeatures.repository.BookRepository;
import com.springbootfeatures.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @MyTimer
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    @MyTimer
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @MyTimer
    public void updateBook(Long bookId, Book book) {
        Optional<Book> found = findById(bookId);
        found.ifPresent(b -> {
            book.setId(b.getId());
            saveBook(book);
        });
    }

    @Override
    @MyTimer
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
