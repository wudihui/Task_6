package com.how2java.controller;


import com.fanchen.util.CookieUtil;
import com.fanchen.util.DesUtil;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Register;
import com.how2java.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
public class CategoryController {
    final String name_error = "该用户名被占用,请换一个再试...";
    final String email_error = "该邮箱已经注册,请登录...";

    final String success = "你登录成功了";
    final String failure = "用户名或密码错误,请重试...";

    final String denglu = "<a href=\"../register\"><span style=\"color: green; \">登录</span></a>";
    final String reg = "<a href=\"../register\"><span style=\"color: green; \">注册</span></a>";
    final String quit = "<a href=\"../register\"><span style=\"color: green; \">注销</span></a>";
    final String index = "<a href=\"../quit\"><span style=\"color: green; \">";
    String end="</span></a>";

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception {
        List<Category> cs = categoryMapper.getAll();
        List<Student> s = categoryMapper.getPp();

        Cookie cokLoginName = CookieUtil.getCookieByName(request, "secretName");
        Cookie cokLoginDate = CookieUtil.getCookieByName(request, "secretDate");
        if (cokLoginDate!=null&&cokLoginName!=null){
            String secretName = cokLoginName.getValue();
            String secretDate = cokLoginDate.getValue();
            String secretKey = "12345678";
            String userName = DesUtil.decryption(secretName, secretKey);
            String loginDate = DesUtil.decryption(secretDate, secretKey);
            model.addAttribute("username",index+userName+end);
            model.addAttribute("reg_quit",quit);
            return "index";
        }
        int a = 0;
        for (Student student : s) {
            a = a + student.getPp_number();
        }
        model.addAttribute("s", a);
        model.addAttribute("cs", cs);
        model.addAttribute("username",denglu);
        model.addAttribute("reg_quit",reg);
        return "index";
    }

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String goM() {
        return "profession";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    //注册
    @RequestMapping(value = "/ok", method = RequestMethod.POST)
    public String ok(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (categoryMapper.getMP(email) != null) {
            Register register = categoryMapper.getMP(email);
            if (register.getUsername().equals(username)) {
                model.addAttribute("name_error", name_error);
                return "register";
            }
            model.addAttribute("email_error", email_error);
            return "register";
        }
        Register register = new Register();
        register.setUsername(username);
        register.setEmail(email);
        register.setPassword(password);
        categoryMapper.register(register);
        model.addAttribute("name", username);
        return "ok";
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException, NullPointerException {
        String key = "12345678";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            //获取email相对的对象
            Register reg = categoryMapper.getMP(email);
            //密码相同则添加Cookie
            if (reg.getPassword().equals(password)) {
                //加密当前时间
                String value = DesUtil.encryption(df.format(new Date()), key);
                //加密用户名
                String name = DesUtil.encryption(reg.getUsername(), key);
                // 添加Cookie
                CookieUtil.addCookie(response, "secretName", name);
                CookieUtil.addCookie(response, "secretDate", value);
                //发送成功信息
                model.addAttribute("success", success);
                return "ok";
            } else {
                model.addAttribute("failure", failure);
                return "register";
            }
        } catch (NullPointerException e) {
            model.addAttribute("failure", failure);
            return "register";
        } catch (Exception e) {
            System.out.println("登录出错了,加密出错");
            return "register";
        }
    }

    @RequestMapping(value = "/quit",method = RequestMethod.GET)
    public String quit(){
        return "none";
    }
}


/**
 * @Controller 控制器
 * @RequestMapping("/") 请求映射
 * ModelAndView  模型和视图
 * @Autowired 自动装配
 * <p>
 * 注册思路
 * 获得用户输入的用户名判断是否存在
 * 如果存在输出提示
 * 如果不存在则判断邮箱是否存在
 */