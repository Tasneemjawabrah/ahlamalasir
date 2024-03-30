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
    private String State;
    private Double totalprice;
    private int serviceid;


    public Reservation(int reservationId, int userId, int hallId, Date date, Time startTime, Time endTime,Double totalprice, int serviceid,String State) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.State=State;
        this.totalprice=totalprice;
        this.serviceid=serviceid;

    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public Integer getServiceId() {
        return serviceid;
    }

    public void setServiceId(Integer serviceid) {
        this.serviceid = serviceid;
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
    public String getState(){
        return State;

    }
    public void setState(String State){
        this.State=State;

    }
    public Double getTotalprice(){
        return totalprice;
    }
    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;


    }

}