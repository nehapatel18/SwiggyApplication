Feature: Test swiggy signup functionality

  Scenario: user is able to signup successfully
    Given user has opened the swiggy homepage
    When user has opens signup page
    And enters following signup details
      | _phonenumber | _name  | _email                  | _password |
      | "1234567890" | "neha" | "nehapatel18@gmail.com" | "abc@123" |
    And clicks continue button on sign page
    Then user is able to signup successfully




