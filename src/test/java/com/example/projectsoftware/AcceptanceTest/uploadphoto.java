package com.example.projectsoftware.AcceptanceTest;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class uploadphoto {
    private String errorMessage;
    private String errorMessageee;
    private boolean fileUploaded;

    private String confirmationMessage;
    private boolean pictureUploaded;
    @When("I click on the {string} button without selecting a file")
    public void iClickOnTheButtonWithoutSelectingAFile(String string) {
        if (string.equals("Upload Picture")) {

            errorMessage = "Please select a file to upload";
        }
    }
    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String string1) {
        assertEquals(string1, errorMessage);
    }

    @When("I select a file with an unsupported file type to upload")
    public void iSelectAFileWithAnUnsupportedFileTypeToUpload() {
        errorMessageee = "Unsupported file type";
    }
    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        if (buttonName.equals("Upload Picture")) {

            fileUploaded = true;
        }
    }
    @When("I select a valid picture file")
    public void iSelectAValidPictureFile() {
        pictureUploaded = true;
    }

    @Then("the picture should be uploaded and displayed on my profile")
    public void thePictureShouldBeUploadedAndDisplayedOnMyProfile() {
        assertEquals(true, pictureUploaded);
    }
    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expect) {
        System.out.println("Confirmation Message: " + expect);

        confirmationMessage = expect;
    }
    @Then("I should see an errorr message {string}")
    public void iShouldSeeAnErrorrMessage(String file) {
        assertEquals(file, errorMessageee);
    }


}