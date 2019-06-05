<%@ page import="org.zhh.domain.News" %>
<%@ page import="java.util.List" %>
<%@ page import="org.zhh.service.impl.NewsServiceImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: junhi
  Date: 2019/5/29
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

    <%--    <c:out ></c:out>--%>

    <jsp:useBean id="newsServiceImpl" class="org.zhh.service.impl.NewsServiceImpl"/>

    <!-- 线性粒子背景特效 -->
    <script type="text/javascript" src="../js/canvas-particle.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            //配置
            var config = {
                vx: 4, //小球x轴速度,正为右，负为左
                vy: 4, //小球y轴速度
                height: 2, //小球高宽，其实为正方形，所以不宜太大
                width: 2,
                count: 70, //点个数
                color: "121, 162, 185", //点颜色
                stroke: "220,220,220", //线条颜色
                dist: 3000, //点吸附距离
                e_dist: 10000, //鼠标吸附加速距离
                max_conn: 10
                //点到点最大连接数
            }
            //调用
            CanvasParticle(config);
        }
    </script>
    <style>
        table {
            /*margin: 0 auto;*/
            border-collapse: collapse;
        }

        table tr th {
            /*height: 28px;*/
            /*line-height: 28px;*/
            background: #f0f7ff;
            border: 1px solid #429fff;
        }

        table tr td {
            /*height: 28px;*/
            /*width: 120px;*/
            border: 1px solid #429fff;
        }

        table tr:nth-child(odd) {
            background-color: #d2e8ff;
        }

        table tr:hover {
            background-color: #CCC;
        }

        #add {
            margin: 0 auto;
        }
    </style>

</head>
<div id="mydiv">
    <body>
        <%
//          List<News> newsAll = newsServiceImpl.getNewsAll();
            NewsServiceImpl newsService = new NewsServiceImpl();
            //获取当前页
            String sPageIndex = request.getParameter("pageIndex");
            Integer pageIndex = 1;
            if(sPageIndex == null || "".equals(sPageIndex)){
                pageIndex = 1;
            }else {
                pageIndex = Integer.valueOf(sPageIndex);
            }
            //获取总数据量
            Integer newsCount = newsService.getNewsCount();

            //设置每页容量
            Integer pageSize = 6;
            //获得总页数
            Integer pageCount = 0;
            if(newsCount % pageSize == 0 ){
                pageCount = newsCount / pageSize;
            }else {
                pageCount = newsCount / pageSize + 1;
            }

            if(pageIndex < 1){
                pageIndex = 1;
            }
            if(pageIndex > pageCount){
                pageIndex = pageCount;
            }

            //获取当前页的新闻
            List<News> newsAll = newsService.getNewsByPage(pageIndex, pageSize);
            request.setAttribute("newsAll", newsAll);
            request.setAttribute("newsCount", newsCount);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("pageCount", pageCount);
%>
    <a id="add" href="add.jsp">点击添加新闻</a><br>
    <a href="admin/admin.jsp">点击跳转管理页</a><br>
    <table border="1" data-reorderable-columns="true">
        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>作者</th>
            <th>新闻类型</th>
            <th>删除</th>
            <th>修改</th>
        </tr>
        <%--        <%--%>
        <%--            for (News news : newsAll) {--%>
        <%--                request.setAttribute("news", news);--%>
        <%--        %>--%>

        <c:forEach items="${newsAll}" var="news">
            <tr>
                <td>${news.id}</td>
                <td><a href="showNews.jsp?id=${news.id}">${news.title}</a></td>
                <td>${news.author}</td>
                <td>${news.type}</td>
                <td><a href="delete.jsp?id=${news.id}">删除</a></td>
                <td><a href="editor.jsp?id=${news.id}">修改</a></td>
            </tr>
            <%--        <%}%>--%>
        </c:forEach>
    </table>

    <div>
        共有${newsCount}条数据；当前${pageIndex}页 共计${pageCount}页

        <c:if test="${pageIndex >1}">
            <a href="index.jsp?pageIndex=1">首页</a>
            <a href="index.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
        </c:if>
        <%
            if (pageIndex < pageCount) {
        %>
        <a href="index.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
        <a href="index.jsp?pageIndex=<%=pageCount%>">末页</a>
        <%
            }
        %>

        <%--index.jsp--%>
        <form action="#">
            <input type="number" name="pageIndex" size="2px">
            <input type="submit" value="跳转">
        </form>
    </div>


</div>

</body>
</html>
