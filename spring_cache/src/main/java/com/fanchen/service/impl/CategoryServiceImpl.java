package com.fanchen.service.impl;

import java.util.Date;
import java.util.List;

import com.fanchen.service.CategoryService;
import com.fanchen.util.MemcachedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanchen.mapper.CategoryMapper;
import com.fanchen.pojo.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Category get(Category category) {
        System.out.println("在缓存中寻找");
        Category c=new Category();
//        设置key
        String key = "category_id(" + category.getId() + ")";
//        通过key获取Category对象
        c = (Category) MemcachedUtil.get(key);
//            在缓存中寻找key
        if (c == null) {
//             如果没找到
            c = categoryMapper.get(category);
//            在数据库里找
            if (c != null) {
                System.out.println("在数据库中找到并添加到缓存");
//            如果在数据库中找到,就放人缓存里
                MemcachedUtil.set(key, c,new Date(1000*64*10));
            }
        }
        return c;
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    public List<Category> list() {
        return categoryMapper.list();
    }

    private String GetKey(Category category, String key_prefix) {
        StringBuilder key = new StringBuilder(key_prefix);
        if (category.getId() != null) {
            key.append("_id(" + category.getId() + ")");
        }
        if (category.getName() != null) {
            key.append("_name(" + category.getName() + ")");
        }
        if (category.getQq() != null) {
            key.append("_qq(" + category.getQq() + ")");
        }
        if (category.getRuxuetime() != null) {
            key.append("_ruxuetime(" + category.getRuxuetime() + ")");
        }
        if (category.getTeacher() != null) {
            key.append("_teacher(" + category.getTeacher() + ")");
        }
        if (category.getUrl() != null) {
            key.append("_url(" + category.getUrl() + ")");
        }
        if (category.getWish() != null) {
            key.append("_wish(" + category.getWish() + ")");
        }
        if (category.getZhuanye() != null) {
            key.append("_zhuanye(" + category.getZhuanye() + ")");
        }
        if (category.getSchool() != null) {
            key.append("_school(" + category.getSchool() + ")");
        }

        return key.toString();
    }
}
