package com.example.projectsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class DateTimeUtil {
 private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtil.class);
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "your_password_here"; // Replace with your actual password

    public static boolean isTimeAvailable(String date, String startTimeStr, String endTimeStr) {
        LocalDate targetDate = LocalDate.parse(date);
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "SELECT COUNT(*) FROM software.reservations WHERE date = ? AND starttime < ? AND endtime > ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, targetDate);
                statement.setObject(2, endTime);
                statement.setObject(3, startTime);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count == 0;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error while checking availability", e);
            return true;
        }
       
        return true;
    }



    private static String getPasswordFromEnvironment() {
     
      
        return "1482003" ;
    }
}
