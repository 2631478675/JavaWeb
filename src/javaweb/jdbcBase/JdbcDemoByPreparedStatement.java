package javaweb.jdbcBase;

import java.sql.*;

/**
 * 尽量使用PreparedStatement 而不是Statement
 * ①提高安全性：使用占位符防止SQL注入
 */
public class JdbcDemoByPreparedStatement {
    public final static String URL = "jdbc:mysql//localhost:3306/jdbc_test";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "123456";
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 使用PreParedStatement
     */
    public static void insertByPreParedStatement(Student student) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "insert into student (name,age)values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //设置SQL语句中占位符的值
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateByPreParedStatement(Student student) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "update student set name = ?,age = ? where id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //设置SQL语句中占位符的值
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Student findByIdAndPreParedStatement(int id) {
        Student student=null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "select name ,age from student where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                student=new Student();
                student.setId(id);
                student.setName(resultSet.getString(1));
                student.setAge(resultSet.getInt(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
