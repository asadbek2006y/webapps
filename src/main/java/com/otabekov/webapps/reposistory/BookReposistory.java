package com.otabekov.webapps.reposistory;

import com.otabekov.webapps.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookReposistory extends JpaRepository<BookStore, Long> {

//    public BookStore save(Book book);
}
