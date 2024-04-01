package com.example.projectsoftware;


import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.Base64;

public  class Halls implements HallService {



        private String name;
        private double price;
        private int capacity;
    private byte[] imageBytes;
    private String location;
    private String state;





        public Halls(){}
    public Halls(String name, double price, int capacity, String location, byte[] imageBytes) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.imageBytes = imageBytes;
    }
    public Halls(String name, double price, int capacity, String location, byte[] imageBytes , String state) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.imageBytes = imageBytes;
        this.state= state;
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
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Image getImage() {
        if (imageBytes != null && imageBytes.length > 0) {
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return new Image(new ByteArrayInputStream(Base64.getDecoder().decode(base64Image)));
        }
        return null;
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
            return name;
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
                e.printStackTrace();
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


