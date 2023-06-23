package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blocks")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameBlog;
    private String content;
    private String date;
    private String author;

    public Blog() {
    }

    public Blog(int id, String nameBlog, String content, String date, String author) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

