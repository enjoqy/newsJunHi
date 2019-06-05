<%@ page import="org.zhh.service.impl.NewsServiceImpl" %>
<%@ page import="com.sun.xml.internal.bind.v2.model.core.ID" %>
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
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"> </script>
</head>
<body>
<div>
    <%
        Integer id = Integer.valueOf(request.getParameter("id"));
        News news = new NewsServiceImpl().getNewsById(id);
    %>

    <form method="post" action="/news/saveEditor">
        <input type="hidden" name="id" value="<%=id%>">
        标题:<input type="text" name="title" value="<%=news.getTitle()%>"><br>
        新闻类型：<input type="text" name="type" value="<%=news.getType()%>"><br>
        作者:<input type="text" name="author" value="<%=news.getAuthor()%>"><br>
        内容：
        <textarea name="content" class="ckeditor">
            <%=news.getContent()%>
        </textarea><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
