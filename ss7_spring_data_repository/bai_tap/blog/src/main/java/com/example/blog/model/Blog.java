package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nameBlog;
    private String content;
    private String date;
    @ManyToOne
    @JoinColumn(name = "category.id", nullable = false)
    private Category category;
    private boolean isFlagDelete;

    public Blog() {
    }

    public Blog(int id, String nameBlog, String content, String date, Category category, boolean isFlagDelete) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.content = content;
        this.date = date;
        this.category = category;
        this.isFlagDelete = isFlagDelete;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFlagDelete() {
        return isFlagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        isFlagDelete = flagDelete;
    }
}