package com.bh.crms.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

public class JdbcUtil {
    //数据源
    private static DataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * string转化日期对象
     */
    public static Date stringToDate(String s )
            throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(s);
    }

    /**
     * 将日期对象转化为string类型
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * UUID获取cid
     * @return
     */
    public static String getId(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

}
