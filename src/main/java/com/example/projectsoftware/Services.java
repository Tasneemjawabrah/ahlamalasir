package com.example.projectsoftware;

import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Services  {
    private int serviceId;
    private String serviceName;
    private String description;
    private double price;
    private int userId;
    private byte[] imageBytes; // Byte array to store image data
    String location;

    // Constructor
    public Services(){};
    public Services(int serviceId, String serviceName, String description, double price, int userId, byte[] imageBytes) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.imageBytes=imageBytes;
    }
    public Services(int serviceId, String serviceName, String description, double price, int userId, byte[] imageBytes, String location) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.imageBytes=imageBytes;
        this.location=location;
    }
    int descriptionn;
    public Services(int serviceId, String serviceName, Integer description, double price, int userId, byte[] imageBytes, String location) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.descriptionn = description;
        this.price = price;
        this.userId = userId;
        this.imageBytes=imageBytes;
        this.location=location;
    }

    // Getters and Setters
    @Override
    public String toString() {
        return getServiceName(); // Or any other meaningful representation
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
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String Location) {
        this.location = Location;
    }


    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
