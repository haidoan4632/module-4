package com.example.book_application.service.impl;

import com.example.book_application.model.Book;
import com.example.book_application.repository.IBookRepository;
import com.example.book_application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> getAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book finById(Integer id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book sach) {
        iBookRepository.save(sach);
    }

}