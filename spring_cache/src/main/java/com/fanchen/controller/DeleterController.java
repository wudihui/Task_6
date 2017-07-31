package com.fanchen.controller;

import com.fanchen.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
public class DeleterController {

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "user/delete",method = RequestMethod.POST)
    public String deleteUser(int id){
        categoryMapper.delete(id);
        return "ok";
    }
}
