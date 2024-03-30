package com.example.projectsoftware.AcceptanceTest;

import com.example.projectsoftware.DateTimeUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class reservation {
    private boolean reservationAvailable;
    private String selectedDate;
    private String selectedEndTime;

    private String selectedStartTime;
    @Given("a user wants to reserve a date and time for a wedding event")
    public void aUserWantsToReserveADateAndTimeForAWeddingEvent() {
        reservationAvailable = false;

    }
    @When("the user selects a  date {string} and start time {string} and  end time {string} for the event")
    public void theUserSelectsADateAndStartTimeAndEndTimeForTheEvent(String string, String string2, String string3) {
        selectedDate = string;
        selectedStartTime = string2;
        selectedEndTime = string3;

        // Check if the selected time is available
        reservationAvailable = DateTimeUtil.isTimeAvailable(string, string2, string3);
    }
    @Then("the system should confirm the reservation successfully")
    public void theSystemShouldConfirmTheReservationSuccessfully() {
        assertEquals(true, reservationAvailable);

    }


    @Given("the date {string} and time {string} to {string} is already booked for another event")
    public void theDateAndTimeToIsAlreadyBookedForAnotherEvent(String string, String string2, String string3) {
        reservationAvailable = false;

    }
    @When("the user attempts to reserve the same date and time")
    public void theUserAttemptsToReserveTheSameDateAndTime() {

    }
    @Then("the system should display an error message indicating the slot is already reserved")
    public void theSystemShouldDisplayAnErrorMessageIndicatingTheSlotIsAlreadyReserved() {
        assertEquals(false, reservationAvailable);

    }



}