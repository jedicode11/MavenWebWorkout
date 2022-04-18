package webworkout.project.dao.impl;


import webworkout.project.util.JdbcConnection;

import java.sql.*;

public class LoginDao {

    private static JdbcConnection JdbcConnection;

//    private static final String LOGIN = "SELECT `username`, `password` FROM users WHERE username = ? AND password = ?";
//    private static final String USER_ROLE = "SELECT role.name FROM users as users JOIN roles role on role.id = user.role_id WHERE username = ?;";
//    private static final String USERS_DATA = "SELECT first_name,last_name,email FROM users WHERE role_id = ACTIVE;";
//


    public boolean login(String username, String password) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/webworkout", "rootPlayer", "123456789");

             PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username = ? and password = ? ")) {
             preparedStatement.setString(1, username);
             preparedStatement.setString(2, password);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable exception : ex) {
            if (exception instanceof SQLException) {
                exception.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) exception).getSQLState());
                System.err.println("Error Code: " + ((SQLException) exception).getErrorCode());
                System.err.println("Message: " + exception.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

