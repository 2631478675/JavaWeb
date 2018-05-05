package javaweb.jdbcByDbUtils.dao;

import javaweb.jdbcByDbUtils.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 接口作用：利于维护
 */
public interface StudentDao {
    void add(Student student) throws SQLException;

    void update(Student student) throws SQLException;

    void delete(int id) throws SQLException;

    Student findById(int id) throws SQLException;

    List<Student> findAll() throws SQLException;

    int studentCount() throws  SQLException;
}
