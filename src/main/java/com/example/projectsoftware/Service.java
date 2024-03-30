package com.example.projectsoftware;

public class Service {

    private final int serviceId;
    private final String serviceName;
    private final String description;
    private final double price;

    public Service(int serviceId, String serviceName, String description, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
