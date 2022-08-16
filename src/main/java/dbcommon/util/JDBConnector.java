package dbcommon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnector {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DatabaseProperty.getConfigFile().getDB_URL(),
                    DatabaseProperty.getConfigFile().getDB_USER(),
                    DatabaseProperty.getConfigFile().getDB_PASS());
            return connection;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
