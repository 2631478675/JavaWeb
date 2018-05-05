package javaweb.jdbcByTempleteUtil.util;

import javaweb.jdbcByDao.util.DBUtilsForJdbcDemoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTempleteUtil {

    public int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtilsForJdbcDemoUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            DBUtilsForJdbcDemoUtil.close(null, connection, preparedStatement);
        }
    }

    public Object query(String sql, HandlerResultSet handlerResultSet, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtilsForJdbcDemoUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            resultSet=preparedStatement.executeQuery(sql);
            return  handlerResultSet.doHandler(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
