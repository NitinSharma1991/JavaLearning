package learning.designPattern.singelton;

public class DatabaseConnection {

    public static volatile DatabaseConnection db;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getDb() {
        if (db == null) {
            synchronized (DatabaseConnection.class) {
                if (db == null) {
                    db = new DatabaseConnection();
                    return db;
                }
            }
        }

        return db;
    }

    public int print() {
        return db.hashCode();
    }
}
