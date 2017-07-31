package com.fanchen.controller;

import com.fanchen.mapper.CategoryMapper;
import com.fanchen.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
public class UpdateController {

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "user/update",method = RequestMethod.POST)
    public String update(Category category){
        categoryMapper.update(category);
        return "ok";
    }

}
