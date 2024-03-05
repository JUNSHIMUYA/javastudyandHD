<%--
  Created by IntelliJ IDEA.
  User: 张清辉
  Date: 2020/10/31
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/gologin">登录</a>
  <a href="${pageContext.request.contextPath}/main">首页</a>

  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" value="upload">
  </form>
  </body>
</html>
