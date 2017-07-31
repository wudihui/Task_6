package com.fanchen.pojo;


import java.io.Serializable;

//Plain Old Java Object类
public class Category implements Serializable {
    private Integer id;
    private String name;
    private String qq;
    private Integer zhuanye;
    private String ruxuetime;
    private String school;
    private String url;
    private String wish;
    private Integer teacher;

    public Integer getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(Integer zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getRuxuetime() {
        return ruxuetime;
    }

    public void setRuxuetime(String ruxuetime) {
        this.ruxuetime = ruxuetime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", zhuanye=" + zhuanye +
                ", ruxuetime='" + ruxuetime + '\'' +
                ", school='" + school + '\'' +
                ", url='" + url + '\'' +
                ", wish='" + wish + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Category(String name, String qq, Integer zhuanye, String school, String url, String wish, Integer teacher) {
        this.name = name;
        this.qq = qq;
        this.zhuanye = zhuanye;
        this.school = school;
        this.url = url;
        this.wish = wish;
        this.teacher = teacher;
    }

    public Category() {
        super();
    }
}
