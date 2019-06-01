package org.zhh.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.zhh.dao.NewsDao;
import org.zhh.domain.News;
import org.zhh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/29 18:50
 */
public class NewsDaoImpl implements NewsDao {

    /**
     * 获取所有的新闻列表
     *
     * @return
     */
    @Override
    public List<News> getNewsList(String sql, Object[] obj) throws SQLException {
        //1.创建一个queryrunner类
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        //2.执行sql  query(...)：执行查询操作  update(...)：执行增删改操作
        List<News> newsList = queryRunner.query(sql, new BeanListHandler<>(News.class), obj);
        return newsList;
    }

    /**
     * 返回一个数组，可用来查询数量
     *
     * @param sql
     * @param obj
     * @return
     * @throws SQLException
     */
    @Override
    public Object[] getObject(String sql, Object[] obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] objTmp = queryRunner.query(sql, new ArrayHandler(), obj);
        return objTmp;
    }

    /**
     * 传入一个sql语句， 和赋值的参数列表
     *
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public Integer update(String sql, Object[] obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Integer rows = queryRunner.update(sql, obj);
        return rows;
    }
















    /*

     */
/**
 * 根据传入的id，查询指定的数据，并返回一个news实体类
 *
 * @param id
 * @return
 * @throws SQLException
 *//*

    @Override
    public News getNewsById(Integer id) throws SQLException {
        String sql = "select * from news where id = " + id;
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        News news = new News();
        while (resultSet.next()) {
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setContent(resultSet.getString("content"));
            news.setType(resultSet.getString("type"));
            news.setSt(resultSet.getInt("st"));
        }
        JDBCUtils.close(connection, preparedStatement);
        return news;
    }

    */
/**
 * 根据传入的id，更改st的状态为0，代表数据被删除，返回受影响的行数
 *
 * @param id
 * @return
 * @throws SQLException
 *//*

    @Override
    public Integer updateNewsById(Integer id) throws SQLException {
        String sql = "update news set st = 0 where id = " + id;
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Integer rows = preparedStatement.executeUpdate();
        return rows;
    }

    @Override
    public Integer save(News news) throws SQLException {
        String sql = "update news set title = ?, author = ?, type = ?, content = ?, st = ? where id = ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, news.getTitle());
        preparedStatement.setString(2, news.getAuthor());
        preparedStatement.setString(3, news.getType());
        preparedStatement.setString(4, news.getContent());
        preparedStatement.setInt(5, news.getSt());
        preparedStatement.setInt(6, news.getId());
        Integer rows = preparedStatement.executeUpdate();

        JDBCUtils.close(connection, preparedStatement);
        return rows;
    }

    @Override
    public Integer insert(News news) throws SQLException {
        String sql = "insert into news (title, author, type, content, st) values (?,?,?,?,?)";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, news.getTitle());
        preparedStatement.setString(2, news.getAuthor());
        preparedStatement.setString(3, news.getType());
        preparedStatement.setString(4, news.getContent());
        preparedStatement.setInt(5, news.getSt());
        Integer rows = preparedStatement.executeUpdate();

        JDBCUtils.close(connection, preparedStatement);
        return rows;
    }

    @Override
    public Integer getNewsCount() throws SQLException {
        String sql = "select count(1) from news where st = 1";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        Integer count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        JDBCUtils.close(connection, preparedStatement);
        return count;
    }

    @Override
    public List<News> getNewsByPage(Integer from, Integer pageSize) throws SQLException {
        String sql = "select * from news where st = 1 limit ?, ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, from);
        preparedStatement.setInt(2, pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<News> newsList = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News();
            news.setId(resultSet.getInt("id"));
            news.setTitle(resultSet.getString("title"));
            news.setAuthor(resultSet.getString("author"));
            news.setContent(resultSet.getString("content"));
            news.setType(resultSet.getString("type"));
            news.setSt(resultSet.getInt("st"));
            newsList.add(news);
        }
        JDBCUtils.close(connection, preparedStatement);

        return newsList;
    }

*/


}
