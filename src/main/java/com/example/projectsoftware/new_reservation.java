package com.example.projectsoftware;

import java.sql.*;
import java.util.ArrayList;

public class new_reservation {
    private int reservationId;
    private int userId;
    private int hallId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private double totalPrice;
    private Double totalPricee;
    private String state;
    private int serviceId;

    public new_reservation(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime,
                double totalPrice, String state, int serviceId) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalPrice = totalPrice;
        this.state = state;
        this.serviceId = serviceId;
    }
    public new_reservation(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime,
                           double totalPrice, String state) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalPrice = totalPrice;
        this.state = state;

    }
    public new_reservation(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime,   Double totalPrice, String state, int serviceId) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state=state;
        this.totalPricee=totalPrice;
        this.serviceId=serviceId;

    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}

