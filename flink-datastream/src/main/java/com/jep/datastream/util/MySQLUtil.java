package com.jep.datastream.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 下午12:30
 */
public class MySQLUtil {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
    }

    public static void close(AutoCloseable closeable) {
        if (null != closeable) {
            try {
                closeable.close(); // null.close
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeable = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}
