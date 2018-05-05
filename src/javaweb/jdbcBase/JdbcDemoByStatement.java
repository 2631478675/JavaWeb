package javaweb.jdbcBase;

import org.springframework.security.access.method.P;

import java.sql.*;

public class JdbcDemoByStatement {

    public final static String URL = "jdbc:mysql//localhost:3306/jdbc_test";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "123456";
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 使用Statement
     */
    public static void insertByStatement() {
        String name="lin";
        try {
            //加载数据库驱动（这是mysql的）
            Class.forName(DRIVER);
            //获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //构造SQL语句
            //sql="insert into student (name,age)values(）"
            String sql = "insert into student (name,age)values('" + name+"')";
            //发送SQL语句的载体
            Statement statement = connection.createStatement();
            //执行数据库SQL语句
            statement.executeUpdate(sql);

            //关闭连接
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //resultSet接口使用，查询指针
    public static void queryByStatement() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select id,name,age FROM student";
            Statement statement = connection.createStatement();
//            statement.executeUpdate(sql);
            //执行查询并返回结果集,resultSet是个指针
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                resultSet.getInt(1);//SQL查询语句的第一行
//                resultSet.getInt("id"); 查询的第二种方法
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateByStatement() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
