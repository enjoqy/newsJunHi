package org.zhh.servlet;

import org.zhh.domain.News;
import org.zhh.service.impl.NewsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * @Author junhi
 * @Date 2019/6/3 12:56
 */
@WebServlet("/news/*")
public class NewsServlet extends BaseServlet {

    /**
     * 执行增加的方法
     * @param request
     * @param response
     * @throws IOException
     */
    public void saveAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        News news = new News();
        news.setTitle(request.getParameter("title"));
        news.setType(request.getParameter("type"));
        news.setAuthor(request.getParameter("author"));
        news.setContent(request.getParameter("content"));
        news.setSt(1);

        int rows = 0;
        try {
            rows = new NewsServiceImpl().insert(news);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rows > 0) {
            response.sendRedirect( request.getAttribute("basePath") + "index.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + "add.jsp");
        }
    }

    /**
     * 执行保存修改的方法
     * @param request
     * @param response
     */
    public void saveEditor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
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
            response.sendRedirect(request.getContextPath() + "index.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + "editor.jsp");
        }
    }
}
