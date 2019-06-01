<%--
  Created by IntelliJ IDEA.
  User: junhi
  Date: 2019/5/29
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"> </script>
</head>
<body>
<form method="post" action="saveAdd.jsp">
    标题:<input type="text" name="title" ><br>
    新闻类型：<input type="text" name="type" ><br>
    作者:<input type="text" name="author" ><br>
    内容：
    <textarea name="content" class="ckeditor">

        </textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
