<%--
  Created by IntelliJ IDEA.
  User: 张清辉
  Date: 2020/10/30
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.10.0/jquery.js"></script>
    <script>
       $(function () {
           $("#btn").click(function () {
               $.post("${pageContext.request.contextPath}/a2",function (data) {
                   var html="";
                    data=JSON.parse(data)
                       for (let i = 0; i < data.length; i++) {
                           html += "<tr>" + "<td>" + data[i].username + "<td>" + data[i].password + "</tr>"
                       }
                   $("#content").html(html);
                   });
           })
       });
    </script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>姓名</td>
        <td>密码</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>
</body>
</html>
