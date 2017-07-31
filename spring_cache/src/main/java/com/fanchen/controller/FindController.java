package com.fanchen.controller;

import com.fanchen.mapper.CategoryMapper;
import com.fanchen.pojo.Category;
import com.fanchen.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
public class FindController {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryServiceImpl categoryService;
    @RequestMapping(value = "user/get",method = RequestMethod.POST)
    public String get(Category category,HttpServletRequest request){
        request.setAttribute("c",categoryService.get(category));
        return "getList";
    }
}
