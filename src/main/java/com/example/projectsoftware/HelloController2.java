package com.example.projectsoftware;

import java.sql.*;

public class HelloController2 {
    public boolean login1Clicked(String eemail, String passw) {


        String query = "SELECT email, password, role FROM software.users WHERE email = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1482003");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, eemail);
            preparedStatement.setString(2, passw);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                switch (role) {
                    case "customer":

                        return true;

                    case "event_planner":
                        return true;

                    case "admin":
                        return true;

                    default:
                        return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean checkbutton(String email, String code) {
        // Check if email and code are empty
        if (email.isEmpty() || code.isEmpty()) {
            System.out.println("Email or code is empty.");
            return false;
        }

        // Database connection parameters
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1482003";

        // SQL query to check if the email and code exist in the users table
        String query = "SELECT userid FROM software.users WHERE email = ? AND code = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Email and code exist, enable password reset fields
                System.out.println("Email and code are correct.");
                // Enable password reset fields or perform other actions
                return true;
            } else {
                // Email or code is incorrect
                System.out.println("Email or code is incorrect.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Method to check if the user ID exists in the database
    public boolean uservalid(int int1) {
        String query = "SELECT COUNT(*) FROM software.users WHERE userid= ?";
        boolean userid = false;

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1482003");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, int1);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    userid = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
        }

        return userid;
    }
}
