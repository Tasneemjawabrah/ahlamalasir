Feature: Hall Search
  As a user
  I want to search for halls
  So that I can find halls based on different criteria


  Scenario: Search for a non-existent hall
    When he search about 'Lona'
    Then I shouldd see 'this hall is not exists'

  Scenario: Search for a valid hall
    When he search about 'Rose'
    Then I sshould see 'Welcome to this halls'