package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class invoice {

    String x;
    @When("user click on invoice and flag is {string}")
    public void userClickOnInvoiceAndFlagIs(String string) {

        assertEquals(true,string.equals("true"));

    }
    @Then("show massage x {string}")
    public void showMassageX(String string) {
        x= string;
        assertEquals(true,string.equals(("the information has been entered successfully")));
    }
}
