<%@ page import="org.zhh.service.impl.NewsServiceImpl" %>
<%@ page import="org.zhh.domain.News" %><%--
  Created by IntelliJ IDEA.
  User: junhi
  Date: 2019/5/29
  Time: 22:32
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
<div>
    <%
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        News news = new News();
        news.setId(Integer.valueOf(request.getParameter("id")));
        news.setTitle(request.getParameter("title"));
        news.setType(request.getParameter("type"));
        news.setAuthor(request.getParameter("author"));
        news.setContent(request.getParameter("content"));
        news.setSt(1);

        int rows = new NewsServiceImpl().save(news);

        if(rows > 0) {
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("editor.jsp");
        }
    %>

</div>
</body>
</html>
