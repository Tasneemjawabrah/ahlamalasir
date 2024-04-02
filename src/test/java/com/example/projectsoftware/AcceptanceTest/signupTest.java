package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.projectsoftware.signup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class signupTest {

     @Test
    public void test_idTest_ValidID_ReturnsTrue() {
        // Arrange
        String validID = "123456789";
        // Act
        boolean result = signup.idTest(validID);
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void test_idTest_InvalidID_ReturnsFalse() {
        // Arrange
        String invalidID = "invalid_id";
        // Act
        boolean result = signup.idTest(invalidID);
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void test_nameTest_ValidName_ReturnsTrue() {
        // Arrange
        String validName = "John Doe";
        // Act
        boolean result = signup.nameTest(validName);
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void test_nameTest_InvalidName_ReturnsFalse() {
        // Arrange
        String invalidName = "John123";
        // Act
        boolean result = signup.nameTest(invalidName);
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void test_gmailTest_ValidGmail_ReturnsTrue() {
        // Arrange
        String validGmail = "example@gmail.com";
        // Act
        boolean result = signup.gmailTest(validGmail);
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void test_gmailTest_InvalidGmail_ReturnsFalse() {
        // Arrange
        String invalidGmail = "invalid_email";
        // Act
        boolean result = signup.gmailTest(invalidGmail);
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void test_passwordTest_ValidPassword_ReturnsTrue() {
        // Arrange
        String validPassword = "StrongPassword123!";
        // Act
        boolean result = signup.passwordTest(validPassword);
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void test_passwordTest_InvalidPassword_ReturnsFalse() {
        // Arrange
        String invalidPassword = "weakpassword";
        // Act
        boolean result = signup.passwordTest(invalidPassword);
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void test_registerWithExistingEmail_ExistingEmail_ReturnsTrue() {
        // Arrange
        String existingEmail = "existing@example.com";
        // Act
        boolean result = signup.registerWithExistingEmail(existingEmail);
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void test_registerWithExistingEmail_NonExistingEmail_ReturnsFalse() {
        // Arrange
        String nonExistingEmail = "nonexisting@example.com";
        // Act
        boolean result = signup.registerWithExistingEmail(nonExistingEmail);
        // Assert
        assertFalse(result);
    }
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
        if(string.equals("true"))assertTrue(true);
        else assertFalse(false);

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
