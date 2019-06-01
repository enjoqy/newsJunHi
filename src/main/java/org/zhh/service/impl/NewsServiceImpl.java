package org.zhh.service.impl;

import org.zhh.dao.impl.NewsDaoImpl;
import org.zhh.domain.News;
import org.zhh.service.NewsService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/29 19:05
 */
public class NewsServiceImpl implements NewsService {

    /**
     * 获取所有的新闻列表
     *
     * @return
     */
    @Override
    public List<News> getNewsAll() throws SQLException {
        String sql = "select * from news where st = 1";
        return new NewsDaoImpl().getNewsList(sql, new Object[]{});
    }

    /**
     * 根据传入的id，查询指定的数据，并返回一个news实体类
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public News getNewsById(Integer id) throws SQLException {
        String sql = "select * from news where id = " + id;
        List<News> newsList = new NewsDaoImpl().getNewsList(sql, new Object[]{});
        News news = newsList.get(0);
        return news;
    }

    /**
     * 根据传入的id，更改st的状态为0，代表数据被删除，返回受影响的行数
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Integer updateNewsById(Integer id) throws SQLException {
        String sql = "update news set st = 0 where id = " + id;
        Object[] obj = {};
        Integer rows = new NewsDaoImpl().update(sql, obj);
        return rows;
    }

    /**
     * 保存修改的新闻
     *
     * @param news
     * @return
     * @throws SQLException
     */
    @Override
    public Integer save(News news) throws SQLException {
        String sql = "update news set title=?, author=?, content=?, type=?, st=? where id=? ";
        Object[] obj = {news.getTitle(), news.getAuthor(), news.getContent(), news.getType(), news.getSt(), news.getId()};
        Integer rows = new NewsDaoImpl().update(sql, obj);
        return rows;
    }

    /**
     * 插入一条新闻
     * @param news
     * @return
     * @throws SQLException
     */
    @Override
    public Integer insert(News news) throws SQLException {
        String sql = "insert into news (title,  author, content, type,  st) values (?,?,?,?,?)";
        Object[] obj = {news.getTitle(), news.getAuthor(), news.getContent(), news.getType(), news.getSt()};
        Integer rows = new NewsDaoImpl().update(sql, obj);
        return rows;
    }

    /**
     * 获得新闻总数
     * @return
     */
    @Override
    public Integer getNewsCount() throws SQLException {
        String sql ="select count(1) from news where st = 1";
        Object[] object = new NewsDaoImpl().getObject(sql, new Object[]{});
        Long tmp = (Long) object[0];
        Integer count = tmp.intValue();
        return count;
    }

    /**
     * 调用者传来的是，分多少页，每页展示多少条数据，第pageIndex页的pageSize条数据
     * 调用dao传入的是，从表的哪个索引开始查，查多少条
     *
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<News> getNewsByPage(Integer pageIndex, Integer pageSize) throws SQLException {
        String sql = "select * from news  where st = 1 limit ?, ?";
        Object[] obj = {(pageIndex - 1) * pageSize, pageSize};
        List<News> newsList = new NewsDaoImpl().getNewsList(sql, obj);
        return newsList;
    }
}
