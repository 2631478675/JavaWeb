package javaweb.jdbcByTempleteUtil.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface HandlerResultSet {
    public Object doHandler(ResultSet resultSet) throws SQLException;
}
