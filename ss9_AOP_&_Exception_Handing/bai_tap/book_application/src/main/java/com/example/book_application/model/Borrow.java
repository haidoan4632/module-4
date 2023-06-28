package com.example.book_application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBorrow;
    private int code;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public Borrow() {
    }

    public Borrow(int idBorrow, int code, Date date, Book book) {
        this.idBorrow = idBorrow;
        this.code = code;
        this.date = date;
        this.book = book;
    }

    public int getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        this.idBorrow = idBorrow;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}