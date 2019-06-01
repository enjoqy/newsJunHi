package test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.zhh.dao.impl.NewsDaoImpl;
import org.zhh.util.JDBCUtils;

import java.sql.SQLException;

/**
 * @Author junhi
 * @Date 2019/5/30 16:50
 */
public class demo01 {

    public static void main(String[] args) throws SQLException {


        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql ="select count(1) from news where st = 2";
        Object[] result = queryRunner.query(sql, new ArrayHandler());

        System.out.println(result[0]);
    }
}
