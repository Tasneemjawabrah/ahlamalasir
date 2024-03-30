Feature: Delete from admin

  Scenario: admin deletes a hall
    Given the user is on the admin panel
    When the user selects a hall to delete with hallid 1
    And the user confirms the deletion
    Then the system should delete the information hall with ID 1

  Scenario: admin deletes a hall not exist
    Given the user isss on the admin panel
    When the user selects a hallkkkk to delete with hallid 5
    And the userrrr confirms the deletion
    Then system should print 'error delete'