package com.springbootfeatures.repository;

import com.springbootfeatures.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
