package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_category;
   @Column(name = "name_category",unique = true,nullable = false)
    private String nameCategory;

   @OneToMany(mappedBy = "category")
    private List<Blog> blogList;

    public Category() {
    }

    public Category(Integer id_category, String nameCategory, List<Blog> blogList) {
        this.id_category = id_category;
        this.nameCategory = nameCategory;
        this.blogList = blogList;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
