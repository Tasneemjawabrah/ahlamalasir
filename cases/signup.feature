Feature: User Registration

  Background:
    Given the user is on the registration page
    And the user has the "Customer" role


  Scenario: a successful signup
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '55'
    And he fills in 'Name' with 'Ahmad'
    And he fills in 'Password Number' with '05*-Aa'
    And he fills in 'Email' with 'shahd22@gmail.com'
    And he presses 'sign up' and flag is 'true'
    Then show massage 'information has been entered successfully'

  Scenario Outline: errors with input
    When I click on sign up and flag is 'true'
    And he fills in 'ID' with '<ID>'
    And he fills in 'Name' with '<Name>'
    And he fills in 'Email' with '<Email>'
    And he fills in 'Password' with '<Password>'
    And he fills in 'Role' with '<Role>'
    And he presses 'sign up' and flag is 'true'
    Then the user should see '<massage>'



    Examples:
      | ID   | Name   | Password     | Email               | Role   |
      | 123  | Ahmad  | password123  | ahmad@gmail.com   | admin |
      | 456  | Razan  | mypass321    | marygmail.com    | Customer   |
      |   | Rawan   | pass456      | khaled@gmail.com  | Customer    |



  @duplicate-email
  Scenario: User attempts to register with a duplicate email
    Given a user with the email "lama@gmail.com" already exists
    When the user tries to register with the same email
    Then the user should see a popup message indicating the email is already in use




