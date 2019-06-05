<%@ page import="org.zhh.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: junhi
  Date: 2019/6/5
  Time: 9:50
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
</head>
<body>

<%
    User user = User.builder()
            .username("admin")
            .build();
    session.setAttribute("user", user);
%>
当前人数：<%=user.getCount()%>

</body>
</html>
