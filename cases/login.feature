Feature: information for log in
  Scenario:empty fields
    When I click on login and flag is 'true'
    Then field '' should be with error

  Scenario: Wrong password
    When he fills in 'razan@gmailcom'
    And hee fills in '1472'
    And I click on login and flag is 'true'
    Then I should see 'E-mail or password is incorrect'

  Scenario: Login successfully
    When he fills in 'lama@gmail.com'
    And hee fills in '12369'
    And I click on login and flag is 'true'
    Then I shouldnt see 'Access your account'