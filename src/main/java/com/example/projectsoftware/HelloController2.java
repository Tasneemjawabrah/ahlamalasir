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
        if (email.isEmpty() || code.isEmpty()) {
            System.out.println("Email or code is empty.");
            return false;
        }

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1482003";

        String query = "SELECT userid FROM software.users WHERE email = ? AND code = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
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
            e.printStackTrace();
            return false;
        }
    }


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
            e.printStackTrace();
        }

        return userid;
    }
}
