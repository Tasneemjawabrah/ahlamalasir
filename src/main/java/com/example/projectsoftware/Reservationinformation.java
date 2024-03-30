package com.example.projectsoftware;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservationinformation {
    private int reservationId;
    private int userId;
    private int hallId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double totalPrice;
    private int serviceId;
    private String state;

    // Constructor
    public Reservationinformation(int reservationId, int userId, int hallId, LocalDate date, LocalTime startTime, LocalTime endTime, double totalPrice, int serviceId, String state) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalPrice = totalPrice;
        this.serviceId = serviceId;
        this.state = state;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getHallId() {
        return hallId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getState() {
        return state;
    }

    // Setters (if needed)
    public void setState(String state) {
        this.state = state;
    }

    // Optional: Override toString() for debugging or logging purposes
    @Override
    public String toString() {
        return "ReservationInfo{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", hallId=" + hallId +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalPrice=" + totalPrice +
                ", serviceId=" + serviceId +
                ", state='" + state + '\'' +
                '}';
    }
}
