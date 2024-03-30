package com.example.projectsoftware;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ReservationInfo {
    private int reservationId;
    private String userName;
    private String hallName;
    private String serviceName;
    private Date date;
    private Time startTime;
    private Time endTime;
    private double totalPrice;
    private String state;

    public ReservationInfo(int reservationId, String userName, String hallName, String serviceName, Date date, Time startTime, Time endTime, double totalPrice, String state) {
        this.reservationId = reservationId;
        this.userName = userName;
        this.hallName = hallName;
        this.serviceName = serviceName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalPrice = totalPrice;
        this.state = state;
    }



    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
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




    private int userId;
    private int hallId;

    private int serviceId;




    // Getters


    public int getUserId() {
        return userId;
    }

    public int getHallId() {
        return hallId;
    }



    public int getServiceId() {
        return serviceId;
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
