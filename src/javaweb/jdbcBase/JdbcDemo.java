package javaweb.jdbcBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDemo {
    public static void insert(){
        try {
            //加载数据库驱动（这是mysql的）
            Class.forName("com.mysql.jdbcBase.Driver");
            //获取数据库连接
            Connection connection= DriverManager.getConnection();
            //构造SQL语句
            String SQL
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
