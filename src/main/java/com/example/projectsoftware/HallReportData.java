package com.example.projectsoftware;

import javafx.beans.property.*;

public class HallReportData {

    private final StringProperty hallName;
    private final DoubleProperty pricePerHour;
    private final IntegerProperty numberOfReservations;
    private final DoubleProperty totalPrice;

    public HallReportData(String hallName, double pricePerHour, int numberOfReservations, double totalPrice) {
        this.hallName = new SimpleStringProperty(hallName);
        this.pricePerHour = new SimpleDoubleProperty(pricePerHour);
        this.numberOfReservations = new SimpleIntegerProperty(numberOfReservations);
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
    }

    public String getHallName() {
        return hallName.get();
    }

    public StringProperty hallNameProperty() {
        return hallName;
    }

    public double getPricePerHour() {
        return pricePerHour.get();
    }

    public DoubleProperty pricePerHourProperty() {
        return pricePerHour;
    }

    public int getNumberOfReservations() {
        return numberOfReservations.get();
    }

    public IntegerProperty numberOfReservationsProperty() {
        return numberOfReservations;
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    public DoubleProperty totalPriceProperty() {
        return totalPrice;
    }
}

