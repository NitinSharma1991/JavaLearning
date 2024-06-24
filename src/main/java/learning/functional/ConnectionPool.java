package learning.functional;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool implements ConnectionPoolInterface {

    public static volatile ConnectionPool db;
    BlockingQueue<Connection> blockingQueue;
    int capacity;
    String username = "Nitin";
    String password = "password";
    String jdbcUrl = "jdbcUrl";
    AtomicInteger size = new AtomicInteger();
    Driver driver;

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
            Properties info = new Properties();
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
        blockingQueue.offer(connection);

    }
}
