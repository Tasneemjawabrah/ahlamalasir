package com.example.projectsoftware;

import java.sql.Date;
import java.sql.Time;

public class NewReservation {
    private int reservationId;
    private int userId;
    private int hallId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private double totalPrice;
    private String state;
    private int serviceId;

    private NewReservation(Builder builder) {
        this.reservationId = builder.reservationId;
        this.userId = builder.userId;
        this.hallId = builder.hallId;
        this.date = builder.date;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.totalPrice = builder.totalPrice;
        this.state = builder.state;
        this.serviceId = builder.serviceId;
    }

    public static class Builder {
        private int reservationId;
        private int userId;
        private int hallId;
        private Date date;
        private Time startTime;
        private Time endTime;
        private double totalPrice;
        private String state;
        private int serviceId;

        public Builder(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime) {
            this.reservationId = reservationId;
            this.userId = userId;
            this.hallId = hallId;
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Builder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder serviceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public NewReservation build() {
            return new NewReservation(this);
        }
    }

    // Getters and setters
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
