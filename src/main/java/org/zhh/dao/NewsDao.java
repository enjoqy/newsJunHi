package org.zhh.dao;

import org.zhh.domain.News;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/29 17:40
 */
public interface NewsDao {

    /**
     * 根据传入的sql，赋值的参数数组，返回一个news的list集合
     *
     * @return
     */
    public List<News> getNewsList(String sql, Object[] obj) throws SQLException;

    /**
     * 根据传入的sql，赋值的参数数组，返回一个object数组
     *
     * @return
     */
    public Object[] getObject(String sql, Object[] obj) throws SQLException;

    /**
     * 根据传入的sql，赋值的参数数组，返回受影响的行数
     *
     * @return
     */
    public Integer update(String sql, Object[] obj) throws SQLException;


















/*
    */
/**
     * 根据传入的id，查询指定的数据，并返回一个news实体类
     * @param id
     * @return
     * @throws SQLException
     *//*

    public News getNewsById(Integer id) throws SQLException;

    */
/**
     * 根据传入的id，更改st的状态为0，代表数据被删除，返回受影响的行数
     *
     * @param id
     * @return
     * @throws SQLException
     *//*

    public Integer updateNewsById(Integer id) throws SQLException;

    */
/**
     * 保存修改的新闻
     * @param news
     * @return
     * @throws SQLException
     *//*

    public Integer save(News news) throws SQLException;

    */
/**
     * 插入一条新闻
     * @param news
     * @return
     * @throws SQLException
     *//*

    public Integer insert(News news) throws SQLException;

    */
/**
     * 获取数据总数
     * @return
     *//*

    public Integer getNewsCount() throws SQLException;

    */
/**
     * 获取页数
     * @return
     *//*

    public List<News> getNewsByPage(Integer frome, Integer pageSize) throws SQLException;
*/

}
