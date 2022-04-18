package webworkout.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnection {
        private static final String dbURL = "jdbc:mysql://localhost:3306/";
        private static final String MySqlData = "webworkout";
        private static final String username = "rootPlayer";
        private static final String password = "123456789";

        private static Connection connection = null;

        private JdbcConnection() {
        }
        static {
            try {
                Connection connection = DriverManager.getConnection(dbURL + MySqlData, username, password);
                if (connection != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
