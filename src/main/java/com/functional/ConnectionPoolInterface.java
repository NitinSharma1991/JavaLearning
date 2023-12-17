package com.functional;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPoolInterface {

    Connection getConnection(long timeout) throws SQLException, InterruptedException;

    void releaseConnection(Connection connection);
}
