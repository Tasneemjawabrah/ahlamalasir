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
    private byte[] imageBytes;
    String location;
    String state;


    public Services(){};
    public Services(int serviceId, String serviceName, String description, double price, int userId, byte[] imageBytes) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.imageBytes=imageBytes;
    }
    public Services(int serviceId, String serviceName, String description, double price, int userId, byte[] imageBytes,String location, String state) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.location=location;
        this.state=state;
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

    @Override
    public String toString() {
        return getServiceName();
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
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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
