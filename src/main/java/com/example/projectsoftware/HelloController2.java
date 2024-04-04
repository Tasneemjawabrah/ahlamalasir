package com.example.projectsoftware;
import java.sql.*;
import java.util.logging.Logger;
public class HelloController2 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
     private static final Logger logger = Logger.getLogger(HelloController2.class.getName());
        private static final String ERROR_MESSAGE =  "error.";
    public boolean login1Clicked(String eemail, String passw) {
        String query = "SELECT email, password, role FROM software.users WHERE email = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, getPasswordFromEnvironment());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, eemail);
            preparedStatement.setString(2, passw);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                switch (role) {
                    case "customer":
                    case "event_planner":
                    case "admin":
                        return true;
                    default:
                        return false;
                }
            }
        } catch (SQLException e) {
              logger.severe( ERROR_MESSAGE );
        }
        return false;
    }
    public boolean checkbutton(String email, String code) {
        if (email.isEmpty() || code.isEmpty()) {
            
                 logger.severe("Email or code is empty.");
            return false;
        }
        String query = "SELECT userid FROM software.users WHERE email = ? AND code = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, getPasswordFromEnvironment());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               
                 logger.severe("Email and code are correct.");
                return true;
            } else {
            logger.severe("Email and code are correct.");
                return false;
            }
        } catch (SQLException e) {
              logger.severe( ERROR_MESSAGE );
            return false;
        }
    }
    public boolean uservalid(int userId) {
        String query = "SELECT COUNT(*) FROM software.users WHERE userid = ?";
        boolean userIdValid = false;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, getPasswordFromEnvironment());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    userIdValid = count > 0;
                }
            }
        } catch (SQLException e) {
                 logger.severe( ERROR_MESSAGE );
         
        }
        return userIdValid;
    }
    private static String getPasswordFromEnvironment() {
        String password = System.getenv("1482003");
        if (password == null) {
                logger.severe( ERROR_MESSAGE );
        }
        return password;
    }
}
