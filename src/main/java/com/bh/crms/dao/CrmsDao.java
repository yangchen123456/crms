package com.bh.crms.dao;

import com.bh.crms.pojo.Crms;
import com.bh.crms.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CrmsDao {
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


    /**
     * 查询所有客户信息
     * @return
     */
    public static List findAll(){
        //编写sql语句
        String sql = "select * from tb_customer ";
        //执行查询
        List<Crms> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Crms.class));
        } catch (SQLException e) {
            System.out.println("查询失败");
        }
        return list;
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    public static Integer deleteById(String id){
        //编写sql语句
        String sql = "delete from tb_customer where cid = ?";

        int i = 0;
        try {
            //执行sql
            i = qr.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
}
