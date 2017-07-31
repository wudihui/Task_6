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
<form action="ok" method="POST">
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>qq</td>
        <td>专业</td>
        <td>入学时间</td>
        <td>毕业院校</td>
        <td>日报地址</td>
        <td>立志</td>
        <td>师兄id</td>

    </tr>
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

</table>
</form>
<%--一定要控制好--%>
<button onclick="window.location.href='/home'">返回主页</button>
</body>
</html>