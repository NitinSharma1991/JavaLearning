package com.functional;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool implements ConnectionPoolInterface {

    BlockingQueue<Connection> blockingQueue;
    int capacity;
    String username = "Nitin";
    String password = "password";
    String jdbcUrl = "jdbcUrl";
    AtomicInteger size = new AtomicInteger();
    Driver driver;

    public static volatile ConnectionPool db;

    private ConnectionPool() {
    }

    public static ConnectionPool getDb() {
        if (db == null) {
            synchronized (ConnectionPool.class) {
                if (db == null) {
                    db = new ConnectionPool();
                    db.blockingQueue = new ArrayBlockingQueue<>(10);
                    return db;
                }
            }
        }

        return db;
    }


    @Override
    public Connection getConnection(long timeout) throws SQLException, InterruptedException {
        long timestamp = System.currentTimeMillis() + timeout;
        boolean createNewConnection = false;
        synchronized (this) {
            while (blockingQueue.isEmpty()) {
                if (size.get() < capacity) {
                    size.incrementAndGet();
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
            Connection con = driver.connect(jdbcUrl, info);
            blockingQueue.offer(con);
            return con;
        } catch (Throwable t) {
            size.decrementAndGet();
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
