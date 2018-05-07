package javaweb.jdbc.jdbcByDao.dao.Impl;

import javaweb.jdbc.jdbcByDao.dao.StudentDao;
import javaweb.jdbc.jdbcByDao.domain.Student;
import javaweb.jdbc.jdbcByDao.util.DBUtilsForJdbcDemoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(Student student) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
       try{
           connection= DBUtilsForJdbcDemoUtil.getConnection();
           String sql="insert into student(name ,age) values(?,?) ";
           preparedStatement= connection.prepareStatement(sql);
           preparedStatement.setString(1,student.getName());
           preparedStatement.setInt(2,student.getAge());
           preparedStatement.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           DBUtilsForJdbcDemoUtil.close(null,connection,preparedStatement);
       }

    }

    @Override
    public void update(Student student) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Student findById(int id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        Student student = null;
        String sql= "select name ,age from student where id = ?";
        try{
            connection= DBUtilsForJdbcDemoUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                student = new Student();
                student.setId(id);
                student.setName(resultSet.getString(1));
                student.setAge(resultSet.getInt(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("根据id查询失败");
        }
        finally {
            DBUtilsForJdbcDemoUtil.close(resultSet,connection,preparedStatement);
        }
        return student;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        Student student = null;
        List<Student> students=new ArrayList<Student>();
        String sql= "select id,name ,age from student";
        try{
            connection= DBUtilsForJdbcDemoUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtilsForJdbcDemoUtil.close(resultSet,connection,preparedStatement);
        }
        return students;
    }
}
