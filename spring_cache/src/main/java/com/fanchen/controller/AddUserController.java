package com.fanchen.controller;

import com.fanchen.pojo.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
public class AddUserController {

    @RequestMapping("/add_user")
    public String add_(Category category) {
        return "addUser";
    }

}
