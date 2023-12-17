package com.functional;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPool implements ConnectionPoolInterface {

    Queue<Connection> blockingQueue;
    int capacity;
    String username = "Nitin";
    String password = "password";
    String jdbcUrl = "jdbcUrl";
    int size = 0;
    Driver driver;

    ConnectionPool(int capacity, Driver driver) {
        this.blockingQueue = new ArrayDeque<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        this.driver = driver;
    }


    @Override
    public Connection getConnection(long timeout) throws SQLException, InterruptedException {
        long timestamp = System.currentTimeMillis() + timeout;
        boolean createNewConnection = false;
        synchronized (this) {
            while (blockingQueue.isEmpty()) {
                if (size < capacity) {
                    size++;
                    createNewConnection = true;
                    break;
                } else {
                    this.wait(timeout);
                    if (timestamp <= System.currentTimeMillis()) {
                        throw new SQLException("Connection not available");
                    }
                }

            }
        }

        if (!createNewConnection) return blockingQueue.poll();

        return createNewConnection();
    }

    private Connection createNewConnection() {
        try {
            java.util.Properties info = new java.util.Properties();
            info.put("user", username);
            info.put("password", password);
            return driver.connect(jdbcUrl, info);
        } catch (Throwable t) {
            size--;
            throw new RuntimeException("Couldn't Create Connection");
        }
    }

    @Override
    public void releaseConnection(Connection connection) {
        synchronized (this) {
            blockingQueue.offer(connection);
            this.notifyAll();
        }
    }
}
