<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张清辉
  Date: 2020/10/28
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
       <input type="hidden" value="${QBooks.bookID}" name="bookID">
        <div class="form-group">
            <label>书籍名称</label>
            <input type="text" class="form-control" name="bookName" value="${QBooks.bookName}" required>
        </div>
        <div class="form-group">
            <label >书籍数量</label>
            <input type="text" class="form-control" name="bookCounts" value="${QBooks.bookCounts}" required>
        </div>
        <div class="form-group">
            <label >书籍描述</label>
            <input type="text" class="form-control" name="detail" value="${QBooks.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>

</body>
</html>

