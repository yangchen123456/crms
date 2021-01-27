package com.bh.crms.dao;

import com.bh.crms.pojo.Crms;
import com.bh.crms.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AddDao {
    //获取数据源
    private static DataSource ds = JdbcUtil.getDataSource();
    //生成QueryRunner对象
    private static QueryRunner qr = new QueryRunner(ds);

    public static int add(Crms crms) {
        //编写sql语句
        String sql = "insert into tb_customer values(?,?,?,?,?,?,?)";

        //设置值
        Object[] objects = {
                crms.getCid(), crms.getCname(), crms.getGender(),
                crms.getBirthday(), crms.getCellphone(),
                crms.getEmail(), crms.getDescription()
        };
        int i = 0;
        try {
            //执行sql
            i = qr.update(sql, objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
