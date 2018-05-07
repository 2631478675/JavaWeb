package javaweb.jdbc.jdbcBase.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtilsForJdbcDemo {

//    public final static String URL = "jdbc:mysql//localhost:3306/jdbc_test";
//    public final static String USERNAME = "root";
//    public final static String PASSWORD = "123456";
//    public final static String DRIVER = "com.mysql.jdbc.Driver";

    public  static String URL = "jdbc:mysql//localhost:3306/jdbc_test";
    public  static String USERNAME = "root";
    public  static String PASSWORD = "123456";
    public  static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 读取配置文件
     */

    private static ResourceBundle resourceBundle=ResourceBundle.getBundle("classpath:db-config");
    //私有化，防止util实例化
    private DBUtilsForJdbcDemo(){

    }

    //使用静态块，驱动只执行一次
    static{
        URL=resourceBundle.getString("jdbc.url");
        USERNAME=resourceBundle.getString("jdbc.username");
        PASSWORD=resourceBundle.getString("jdbc.password");
        DRIVER=resourceBundle.getString("jdbc.driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
        return  connection;
    }

    public static void close(ResultSet resultSet, Statement statement, PreparedStatement preparedStatement){

            try {
                if(resultSet!=null){
                    resultSet.close();
                }
               if(statement!=null){
                    statement.close();
               }
               if(preparedStatement!=null){
                    preparedStatement.close();
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
