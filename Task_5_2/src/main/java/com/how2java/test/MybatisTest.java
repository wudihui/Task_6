package com.how2java.test;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Register;
import com.how2java.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private CategoryMapper categoryMapper;

    //  测试插入数据
    @Test
    public void addStudent() {
        Category student = new Category();
        student.setName("刘德华");
        student.setMagor("四大天王");
        student.setJianjie("aaaaaaaaaaa");
        student.setPortrait("liudehua.png");
        categoryMapper.add(student);
    }

    //  测试获取优秀学生信息
    @Test
    public void getAll() {
        List<Category> cs = categoryMapper.getAll();
        for (Category c : cs) {
            System.out.println(c.getId());
            System.out.println(c.getName());
            System.out.println(c.getMagor());
            System.out.println(c.getJianjie());
            System.out.println(c.getPortrait());
        }
    }

    //测试获取人数
    @Test
    public void getPP() {
        List<Student> cs = categoryMapper.getPp();
        int a = 0;
        for (Student p : cs) {
            int pp = p.getPp_number();
            a = a + pp;
        }
        System.out.println(a);
    }

    @Test
    public void register() {
        Register register = new Register();
        register.setUsername("凡尘");
        register.setEmail("897254488@qq.com");
        register.setPassword("12345678");
        categoryMapper.register(register);
    }

    @Test
    public void login() {
        System.out.println(categoryMapper.getMP("897254488@qq.com").getPassword());
    }
    @Test
    public void getPas(){
        Register register=categoryMapper.getMP("897254488@qq.com");
        System.out.println(register.getUsername());
        System.out.println(register.getEmail());
        System.out.println(register.getPassword());

    }
}

