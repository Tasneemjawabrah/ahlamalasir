package com.example.projectsoftware;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hall {
    public int hallId;
    public String hallName;
    public int capacity;
    public double pricePerHour;
    public String location;
    public int userId;
    public Hall(int hallId, String hallName, int capacity, double pricePerHour, String location, int userId) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.capacity = capacity;
        this.pricePerHour = pricePerHour;
        this.location = location;
        this.userId = userId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


  private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = getPasswordFromEnvironment();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private static String getPasswordFromEnvironment() {
        String password = System.getenv("1482003");
        if (password == null) {
            throw new IllegalStateException("Database password not found in environment variables.");
        }
        return password;
    }


}
