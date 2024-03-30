package com.example.projectsoftware;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.Base64;

public  class Halls implements HallService {



        private String name;
        private double price;
        private int capacity;
    private byte[] imageBytes; // Byte array to store image data
    private String location; // Add location field

    // Constructor, getters, setters, and other methods remain unchanged




        public Halls(){}
    public Halls(String name, double price, int capacity, String location, byte[] imageBytes) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.imageBytes = imageBytes;
    }

    public Halls(String name, double price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;

    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    // Method to convert byte array to JavaFX Image
    public Image getImage() {
        if (imageBytes != null && imageBytes.length > 0) {
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return new Image(new ByteArrayInputStream(Base64.getDecoder().decode(base64Image)));
        }
        return null; // Return null if imageBytes is empty
    }
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getCapacity() {
            return capacity;
        }
        @Override
        public String toString() {
            return name; // Return the name of the hall for display in ListView
        }
        public static boolean isHallExists(String hallName) {
            String query = "SELECT COUNT(*) FROM software.Halls WHERE hallname = ?";
            boolean hallExists = false;

            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1482003");
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, hallName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        hallExists = count > 0;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception based on your application's needs
            }

            return hallExists;
        }

    private int hallId;
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

}


