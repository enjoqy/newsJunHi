<%@ page import="org.zhh.service.impl.NewsServiceImpl" %>
<%@ page import="org.zhh.service.NewsService" %>
<%@ page import="org.zhh.domain.News" %><%--
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
</head>
<body>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    NewsService newsService = new NewsServiceImpl();
    int rows = newsService.updateNewsById(id);
    if (rows > 0) {
        response.sendRedirect("index.jsp");
    } else {
%>
<h4>删除失败</h4>
<a href="index.jsp">点击跳转</a>
<%
    }
%>

</body>
</html>
