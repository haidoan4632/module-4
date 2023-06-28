package com.example.book_application.service;

import com.example.book_application.model.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> getAll();
    Borrow findById(int id);
    void save(Borrow borrow);
    boolean findByCode(int code);
}
