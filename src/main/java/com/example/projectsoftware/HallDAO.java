package com.example.projectsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1482003";

    public static String[] getHallsBasedOnBudget(double budget) {
        List<String> hallsList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT hallname FROM software.halls WHERE priceperhour <= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, budget);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String hallName = resultSet.getString("hallname");
                hallsList.add(hallName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hallsList.toArray(new String[0]);
    }
}
