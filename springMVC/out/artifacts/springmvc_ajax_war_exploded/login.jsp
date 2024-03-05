<%--
  Created by IntelliJ IDEA.
  User: 张清辉
  Date: 2020/10/31
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.10.0/jquery.js"></script>
    <script>
        function a1() {

            $.ajax({
                url:"${pageContext.request.contextPath}/a3",
                data:{"name":$("#name").val()},
                success:function (data1) {
                    console.log(data1.toString())
                    if(data1==="ok")
                    {
                        console.log("1");
                        $("#nameInfo").css("color","green");
                    }
                    $("#nameInfo").html(data1)
                }
            })
        }
        function a2() {
            $.ajax({
                url:"${pageContext.request.contextPath}/a3",
                data:{"pwd":$("#pwd").val()},
                success:function (data1) {
                    console.log(data1)
                }
            })
        }
    </script>
</head>
<body>
    <p>
        用户名：<input type="text" id="name" onblur="a1()">
        <span id="nameInfo"></span>
    </p>
    <p>
       密码：<input type="password" id="pwd" onblur="a2()">
        <span id="pwdInfo"></span>
    </p>
</body>
</html>
