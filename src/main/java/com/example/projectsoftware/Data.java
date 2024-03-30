package com.example.projectsoftware;

import javafx.beans.property.*;

public class Data {
    private final IntegerProperty idserorhall;
    private final StringProperty name;
    private final IntegerProperty userid;
    private final DoubleProperty price;
    private final StringProperty location;
    private final IntegerProperty capacity;
    private final StringProperty description;
    private final ObjectProperty<byte[]> image;

    public Data(int idserorhall, String name, int userid, double price, String location, int capacity, String description, byte[] image) {
        this.idserorhall = new SimpleIntegerProperty(idserorhall);
        this.name = new SimpleStringProperty(name);
        this.userid = new SimpleIntegerProperty(userid);
        this.price = new SimpleDoubleProperty(price);
        this.location = new SimpleStringProperty(location);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.description = new SimpleStringProperty(description);
        this.image = new SimpleObjectProperty<>(image);
    }

    public int getIdserorhall() {
        return idserorhall.get();
    }

    public IntegerProperty idserorhallProperty() {
        return idserorhall;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getUserid() {
        return userid.get();
    }

    public IntegerProperty useridProperty() {
        return userid;
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public int getCapacity() {
        return capacity.get();
    }

    public IntegerProperty capacityProperty() {
        return capacity;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public byte[] getImage() {
        return image.get();
    }

    public ObjectProperty<byte[]> imageProperty() {
        return image;
    }
}
