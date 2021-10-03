Feature: test swiggy login functionality
  @RegressionTest
  Scenario: user is able to login successfully
    Given user has opend swiggy homepage
    When user click the login button
    Then user enter following details
      | login phone number | 8347110342 |
    And clicks on login button
    And user enter otp
    Then clicks on verify otp button






