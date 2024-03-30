Feature: Upload Profile Picture

  Scenario: Empty Picture Selection
    When I click on the "Upload Picture" button without selecting a file
    Then I should see an error message "Please select a file to upload"

  Scenario: Unsupported File Type
    When I select a file with an unsupported file type to upload
    And I click on the "Upload Picture" button
    Then I should see an errorr message "Unsupported file type"

  Scenario: Successful Picture Upload
    When I select a valid picture file
    And I click on the "Upload Picture" button
    Then the picture should be uploaded and displayed on my profile
    And I should see a confirmation message "Picture uploaded successfully"