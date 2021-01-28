package com.bh.crms.util;

import com.bh.crms.pojo.Crms;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    public static Crms tocrms(Map<String, String[]> map){

        Crms crms = new Crms();

        for (Map.Entry<String, String[]> m : map.entrySet()) {

            String name = m.getKey();
            String[] values = m.getValue();
            //属性描述器：表示JavaBean类通过存储器导出一个属性
            PropertyDescriptor pd=null;
            try {
                pd = new PropertyDescriptor(name, Crms.class);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }

            if (values!=null&& pd !=null) {

                Method setter = pd.getWriteMethod();
                try {
                    if (values.length==1) {
                        setter.invoke(crms, values[0]);
                    }else {
                        setter.invoke(crms, (Object)values);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("获取表单数据之后："+crms.toString());
        return crms;
    }

    }


