Feature: Edit User Information

  Scenario: Editing user information with existing ID
    When the user edits their information with valid ID for example 147
    And the user clicks on the "Edit" button
    Then the system should update the user information in the database

  Scenario: Editing user information with non-existing ID
    When the user edits their information with invalid ID for example 56
    And clicks on the "Edit" button
    Then the system should display an error message