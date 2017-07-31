<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
</head>
<body>

<%--显示--%>
<form action="add_user" method="POST">
<table align='center' border='1' cellspacing='0'>
    <tr><th colspan=9><h2>学员信息表</h2></th></tr>
    <tr>
        <td>学号</td>
        <td>名字</td>
        <td>qq</td>
        <td>专业</td>
        <td>插入时间</td>
        <td>毕业院校</td>
        <td>日报地址</td>
        <td>立志</td>
        <td>师兄学号</td>

    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.qq}</td>
            <td>${c.zhuanye}</td>
            <td>${c.ruxuetime}</td>
            <td>${c.school}</td>
            <td>${c.url}</td>
            <td>${c.wish}</td>
            <td>${c.teacher}</td>

        </tr>
    </c:forEach>
    <tr><th colspan=9><button onclick="window.location.href='/add_user'">添加</button>
    </th></tr>
</table>
</form>
<hr/>

<h1>删除：</h1>
<br><form action="user/delete" method="POST">
    输入要删除的ID：<input type="number" name="id"><input type="submit" value="提交"><br>
</form><br>
<hr/>

<h1>查询：</h1>

<br><form action="user/get" method="POST">
    输入要查询的ID：<input type="text" name="id"><input type="submit" value="提交"><br>
</form><br>

<hr/>

<h1>修改：</h1><br><form action="user/update" method="POST">
    输入要修改的ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id"><br>
    输入要修改的名字：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"><br>
    输入要修改的学校：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="school"><br>
    输入要修改的专业：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="zhuanye"><br>
    输入要修改的qq：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="qq"><br>
    输入要修改的立志：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="wish"><br>
    输入要修改的师兄id：&nbsp;&nbsp;<input type="text" name="teacher"><br>
    输入要修改的日报地址：<input type="text" name="url"><br>
    <input type="submit" value="提交">
</form><br>
<hr/>
</body>
</html>