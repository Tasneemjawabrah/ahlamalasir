package com.example.projectsoftware;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
    private int reservationId;
    private int userId;
    private int hallId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String state;
    private Double totalPrice;
    private int serviceId;

    private Reservation(ReservationBuilder builder) {
        this.reservationId = builder.reservationId;
        this.userId = builder.userId;
        this.hallId = builder.hallId;
        this.date = builder.date;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.state = builder.state;
        this.totalPrice = builder.totalPrice;
        this.serviceId = builder.serviceId;
    }

    // Getters for all variables
    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getHallId() {
        return hallId;
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String getState() {
        return state;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    // Builder class
    public static class ReservationBuilder {
        private int reservationId;
        private int userId;
        private int hallId;
        private Date date;
        private Time startTime;
        private Time endTime;
        private String state;
        private Double totalPrice;
        private int serviceId;

        // Constructor with required parameters
        public ReservationBuilder(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime) {
            this.reservationId = reservationId;
            this.userId = userId;
            this.hallId = hallId;
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // Setter methods for optional parameters
        public ReservationBuilder state(String state) {
            this.state = state;
            return this;
        }

        public ReservationBuilder totalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public ReservationBuilder serviceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        // Build method to create an instance of Reservation
        public Reservation build() {
            return new Reservation(this);
        }
    }
}
