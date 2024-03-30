package com.example.projectsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeUtil {

    public static boolean isTimeAvailable(String date, String startTimeStr, String endTimeStr) {
        LocalDate targetDate = LocalDate.parse(date);
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1482003")) {
            String query = "SELECT COUNT(*) FROM software.reservations WHERE date = ? AND starttime < ? AND endtime > ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, targetDate);
                statement.setObject(2, endTime);
                statement.setObject(3, startTime);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count == 0; // If count is zero, time is available; otherwise, it's not
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }

        // Return true by default if an error occurs
        return true;
    }
}
