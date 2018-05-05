package javaweb.jdbcByTempleteUtil.dao;

import javaweb.jdbcByTempleteUtil.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 接口作用：利于维护
 */
public interface StudentDao {
    public void add(Student student)throws SQLException;
    public void update(Student student)throws SQLException;
    public void delete(int id)throws SQLException;
    public Student findById(int id) throws SQLException;
    public List<Student> findAll() throws SQLException;
}
