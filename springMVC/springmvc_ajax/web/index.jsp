<%--
  Created by IntelliJ IDEA.
  User: 张清辉
  Date: 2020/10/30
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.10.0/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/statics/js/"></script>
    <script>
      function a()
      {
        $.ajax({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("#username").val()},
          success:function (data1) {
           console.log(data1)
          }
        })
      }
    </script>
  </head>
  <body>
  <input type="text" id="username" onblur="a()">
  </body>
</html>
