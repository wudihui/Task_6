package com.fanchen.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fanchen.pojo.Category;
import com.fanchen.service.CategoryService;
import com.fanchen.mapper.CategoryMapper;

// 告诉spring mvc这是一个控制器类
@Controller
public class HomeController {

    //	成功
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryService categoryService;

//    请求映射
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView listCategory(){
        ModelAndView mav = new ModelAndView();

        List<Category> cs= categoryService.list();

        // 放入转发参数
        mav.addObject("cs", cs);

        // 放入jsp路径
        mav.setViewName("listCategory");
        return mav;
    }

}