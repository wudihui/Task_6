package com.how2java.mapper;

import com.how2java.pojo.Category;
import com.how2java.pojo.Register;
import com.how2java.pojo.Student;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public interface CategoryMapper {
    int add(Category category);

    List<Category> getAll();

    List<Category> list();

    List<Student> getPp();

    void register(Register register);

    Register getMP(String email);

}