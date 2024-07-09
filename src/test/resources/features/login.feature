Feature: Login

  @loginPositive
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on Login icon
    Then User verifies Login form
    When User enters valid data
    And User clicks on Anmelden button
    Then User verifies user name status
    When User clicks on Login icon
    Then User verifies user name

    @loginNegative
    Scenario: Login with invalid password
      Given User is on HomePage
      When User clicks on Login icon
      Then User verifies Login form
      When User enters valid email and invalid password
      And User clicks on Anmelden button
      Then User verifyes Error Message is displayed


