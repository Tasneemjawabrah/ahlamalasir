package com.example.projectsoftware.AcceptanceTest;

import com.example.projectsoftware.HelloController2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class editing {

    HelloController2 i = new HelloController2();
    int x;
    @When("the user edits their information with valid ID for example {int}")
    public void theUserEditsTheirInformationWithValidIDForExample(Integer int1) {
        x  = int1;

    }
    @Then("the system should update the user information in the database")
    public void theSystemShouldUpdateTheUserInformationInTheDatabase() {
        assertEquals(true,i.uservalid(x));
    }


    @When("the user edits their information with invalid ID for example {int}")
    public void theUserEditsTheirInformationWithInvalidIDForExample(Integer int1) {
        x  = int1;
    }
    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
        assertEquals(false,i.uservalid(x));
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String string) {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("rtye");
    }


    @When("clicks on the {string} button")
    public void clicksOnTheButton(String string) {
      System.out.println("ok");
    }

}
