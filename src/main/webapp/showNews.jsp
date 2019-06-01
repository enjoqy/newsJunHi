<%@ page import="org.zhh.service.impl.NewsServiceImpl" %>
<%@ page import="org.zhh.domain.News" %><%--
  Created by IntelliJ IDEA.
  User: junhi
  Date: 2019/5/29
  Time: 19:48
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
    <jsp:useBean id="newsServiceImpl" class="org.zhh.service.impl.NewsServiceImpl"/>
</head>
<body>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    News news = newsServiceImpl.getNewsById(id);
%>
<h1><%=news.getTitle()%></h1>
<h4><%=news.getType()%></h4>
责任编辑：<span><%=news.getAuthor()%></span>
<div><%=news.getContent()%></div>
</body>
</html>
