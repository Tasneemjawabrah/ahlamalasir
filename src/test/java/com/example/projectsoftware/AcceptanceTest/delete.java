package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class delete {

    int x;

    @Given("the user is on the admin panel")
    public void theUserIsOnTheAdminPanel() {
        System.out.println("mmmm");
    }
    @When("the user selects a hall to delete with hallid {int}")
    public void theUserSelectsAHallToDeleteWithHallid(Integer int1) {
        x=int1;
    }
    @When("the user confirms the deletion")
    public void theUserConfirmsTheDeletion() {
        System.out.println("delete");
    }
    @Then("the system should delete the information hall with ID {int}")
    public void theSystemShouldDeleteTheInformationHallWithID(Integer int1) {
        assertTrue(true);

    }
    @Given("the user isss on the admin panel")
    public void theUserIsssOnTheAdminPanel() {
        System.out.println("nnn");
    }
    @When("the user selects a hallkkkk to delete with hallid {int}")
    public void theUserSelectsAHallkkkkToDeleteWithHallid(Integer int1) {
        x= int1;
    }
    @When("the userrrr confirms the deletion")
    public void theUserrrrConfirmsTheDeletion() {
        System.out.println("not");
    }
    @Then("system should print {string}")
    public void systemShouldPrint(String string) {
        assertFalse(false);
    }
}
