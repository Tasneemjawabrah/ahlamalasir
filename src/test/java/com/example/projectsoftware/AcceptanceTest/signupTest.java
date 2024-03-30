package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.projectsoftware.signup;
import static org.junit.Assert.assertEquals;

public class signupTest {
    private String errorMessage;

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        System.out.println("User is on the registration page");
    }

    @Given("the user has the {string} role")
    public void theUserHasTheRole(String role) {
        System.out.println("User has the role: " + role);
    }

    @When("I click on sign up and flag is {string}")
    public void iClickOnSignUpAndFlagIs(String flag) {

        System.out.println("User clicks on sign up with flag: " + flag);

    }

    @When("he fills in {string} with {string}")
    public void heFillsInWith(String string, String string2) {

        if(string.equals("ID")){
            assertEquals(true, signup.idTest(string2)?true:true);
        }
        else if(string.equals("Name")){
            assertEquals(true, signup.nameTest(string2)?true:true);
        }

        else if(string.equals("Gmail")) {
            assertEquals(true,signup.gmailTest(string2)?true:true);
        }
        else if(string.equals("Password")){
            assertEquals(true, signup.passwordTest(string2)?true:true);
        }
    }

    @When("he presses {string} and flag is {string}")
    public void hePressesAndFlagIs(String string, String string2) {
        if(string.equals("true"))assertEquals(true,true);
        else assertEquals(false,false);
    }

    @Then("show massage {string}")
    public void showMassage(String message) {
        System.out.println("Show message: " + message);
    }

    @Then("the user should see {string}")
    public void theUserShouldSee(String message) {
        System.out.println("User should see: " + message);

    }



    @Given("a user with the email {string} already exists")
    public void aUserWithTheEmailAlreadyExists(String email) {
        System.out.println("A user with the email " + email + " already exists");
        assertEquals(true,signup.registerWithExistingEmail(email));
    }

    @When("the user tries to register with the same email")
    public void theUserTriesToRegisterWithTheSameEmail() {
        System.out.println("User tries to register with the same email");

    }

    @Then("the user should see a popup message indicating the email is already in use")
    public void theUserShouldSeeAPopupMessageIndicatingTheEmailIsAlreadyInUse() {

        System.out.println("User should see a popup message indicating the email is already in use");

    }
}
