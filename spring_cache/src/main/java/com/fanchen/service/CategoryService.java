package com.fanchen.service;

import java.util.List;

import com.fanchen.pojo.Category;

public interface CategoryService {

    int add(Category category);

    void delete(int id);

    Category get(Category category);

    int update(Category category);

    List<Category> list();

}
