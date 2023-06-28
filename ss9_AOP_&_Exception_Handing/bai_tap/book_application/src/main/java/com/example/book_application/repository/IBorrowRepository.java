package com.example.book_application.repository;

import com.example.book_application.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow,Integer> {
    public boolean findByCode(int code);
}
