<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/29
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>


<%--添加--%>
<form action="ok" method="POST
">
    <table align='center' border='1' cellspacing='0'>
        <%--align让表格居中显示--%>
        <tr>
            <td>添加</td>
        </tr>
        <tr>
            <td>名字&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"></td>
        </tr>
        <tr>
            <td>专业&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="zhuanye"></td>
        <tr/>
        <tr>
            <td>师兄id&nbsp;&nbsp;<input type="text" name="teacher"></td>
        </tr>
        <tr>
            <td>qq&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="qq"></td>
        </tr>
        <tr>
            <td>日报地址<input type="text" name="url"></td>
        <tr/>
        <tr>
            <td>立志&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="wish"></td>
        <tr/>
        <tr>
            <td>毕业院校<input type="text" name="school"></td>
        <tr/>

        <tr>
            <th colspan=2><input type="reset" value="重设">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="添加"></th>
        </tr>
    </table>
</form>

<body/>
</body>
</html>
