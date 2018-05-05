package javaweb.jdbcByTempleteUtil.dao.Impl;

import javaweb.jdbcByDao.util.DBUtilsForJdbcDemoUtil;
import javaweb.jdbcByTempleteUtil.dao.StudentDao;
import javaweb.jdbcByTempleteUtil.domain.Student;
import javaweb.jdbcByTempleteUtil.util.HandlerResultSet;
import javaweb.jdbcByTempleteUtil.util.JdbcTempleteUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTempleteUtil jdbcTempleteUtil;

    public StudentDaoImpl() {
        jdbcTempleteUtil = new JdbcTempleteUtil();
    }

    @Override
    public void add(Student student) throws SQLException {
        String sql = "insert into student(name,age)values(?,?)";
        jdbcTempleteUtil.update(sql, student.getName(), student.getAge());
    }

    @Override
    public void update(Student student) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Student findById(int id) throws SQLException {
        String sql = "select name ,age from student where id = ?";
        return (Student) jdbcTempleteUtil.query(sql,
                new HandlerResultSet() {
                    @Override
                    public Object doHandler(ResultSet resultSet) throws SQLException {
                        Student student = null;
                        if (resultSet.next()) {
                            student = new Student();
                            student.setId(id);
                            student.setName(resultSet.getString(1));
                            student.setAge(resultSet.getInt(2));
                        }
                        return student;
                    }
                }
                , id);
    }

    @Override
    public List<Student> findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        List<Student> students = new ArrayList<Student>();
        String sql = "select id,name ,age from student";
        try {
            connection = DBUtilsForJdbcDemoUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtilsForJdbcDemoUtil.close(resultSet, connection, preparedStatement);
        }
        return students;
    }
}
