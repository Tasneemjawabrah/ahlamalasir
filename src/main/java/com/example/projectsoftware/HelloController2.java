package com.example.projectsoftware;

import java.sql.*;

public class HelloController2 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";

    public boolean login1Clicked(String email, String password) throws DatabaseException {
        String query = "SELECT email, password, role FROM software.users WHERE email = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, getPasswordFromEnvironment());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
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
            throw new DatabaseException("Error occurred while logging in", e);
        }
        return false;
    }

    public boolean checkButton(String email, String code) {
        if (email.isEmpty() || code.isEmpty()) {
            System.out.println("Email or code is empty.");
            return false;
        }
        String query = "SELECT userid FROM software.users WHERE email = ? AND code = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, getPasswordFromEnvironment());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Email and code are correct.");
                return true;
            } else {
                System.out.println("Email or code is incorrect.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error while checking availability: " + e.getMessage());
            return false;
        }
    }

    public boolean userValid(int userId) {
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
            System.err.println("Error while checking user validity: " + e.getMessage());
        }
        return userIdValid;
    }

    private static String getPasswordFromEnvironment() {
        String password = System.getenv("1482003");
        if (password == null) {
            throw new IllegalStateException("Database password not found in environment variables.");
        }
        return password;
    }
}
