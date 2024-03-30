Feature: Manage Reservations in Wedding Application

  Scenario: Reserve a date and time successfully
Given a user wants to reserve a date and time for a wedding event
When the user selects a  date "2024-07-15" and start time "15:00:00" and  end time "17:00:00" for the event
Then the system should confirm the reservation successfully

Scenario: Attempt to reserve an already booked date and time
And the date "2024-06-15" and time "15:00:00" to "17:00:00" is already booked for another event
When the user attempts to reserve the same date and time
Then the system should display an error message indicating the slot is already reserved




