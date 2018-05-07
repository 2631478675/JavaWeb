package javaweb.jdbc.jdbcByDbUtils.dao.Impl;

import javaweb.jdbc.jdbcByDao.util.DBUtilsForJdbcDemoUtil;
import javaweb.jdbc.jdbcByDbUtils.dao.StudentDao;
import javaweb.jdbc.jdbcByDbUtils.domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner runner=null;
    public StudentDaoImpl(){
        runner = new QueryRunner();
    }
    /**
     * http://www.voidcn.com/article/p-wuioieir-pt.html
     * @param student
     * @throws SQLException
     */

    @Override
    public void add(Student student) throws SQLException {
        String sql = "insert into student(name,age)values(?,?)";
        runner.update(DBUtilsForJdbcDemoUtil.getConnection(),sql,student.getName(),student.getAge());
    }

    @Override
    public void update(Student student) throws SQLException {
        String sql = "update student set name =? ,age =? where id =?";
        runner.update(DBUtilsForJdbcDemoUtil.getConnection(),sql,student.getName(),student.getAge(), student.getId());
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from student where id =? ";
        runner.update(DBUtilsForJdbcDemoUtil.getConnection(),sql,id);
    }

    /**
     * 使用BeanHandler查询一个对象
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Student findById(int id) throws SQLException {
        String sql= "select name ,age from student where id =? ";
        //已经过时
//        runner.query(DBUtilsForJdbcDemoUtil.getConnection(),sql,new Object[]{id},new BeanHandler<Student>(Student.class));
        Student student=runner.query(DBUtilsForJdbcDemoUtil.getConnection(),sql,new BeanHandler<Student>(Student.class),id);
        return student;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        String sql= "select name ,age from student";
        List<Student> students = runner.query(DBUtilsForJdbcDemoUtil.getConnection(),sql,new BeanListHandler<Student>(Student.class));
        return students;
    }

    @Override
    public int studentCount() throws SQLException {
        String sql = "select count(id) from student";
        return runner.query(sql,new ScalarHandler<Integer>());
    }


}
