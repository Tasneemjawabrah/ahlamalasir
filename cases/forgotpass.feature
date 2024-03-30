Feature: information for check

  Scenario:empty fields
    When I click on check and flag is 'true'
    Then field '' shouldddd be with error

  Scenario: Wrong check
    When he fillllls in 'razan@gmailcom'
    And hee fillllls in '1472'
    And I click on check and flag is 'true'
    Then I shoulddddd see 'E-mail or code is incorrect'

  Scenario: check successfully
    When he fillllls in 'lama@gmail.com'
    And hee fillllls in '543'
    And I click on check and flag is 'true'
    Then I shouldntttt see 'Access your account'