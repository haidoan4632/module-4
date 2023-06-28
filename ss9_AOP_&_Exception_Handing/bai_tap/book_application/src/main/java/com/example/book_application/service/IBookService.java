package com.example.book_application.service;

import com.example.book_application.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book finById(Integer id);
    void save(Book book);
}
