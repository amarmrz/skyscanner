@Search
Feature: Search

  @Smoke @regression
  Scenario: User search flights successfully
    Given User navigate to the website
    And   User type the flight info
    When  User clicks on search
    Then  User redirected to available flights
#It is possible to hard code the inputs data

  @Smoke @regression
  Scenario: User search hotels successfully
    Given User navigate to the website
    And   User clicks on Hotels button
    And   User type the Hotels info
    When  User clicks on search hotel
    Then  User redirected to available Hotels
#It is possible to hard code the inputs data

  @Smoke @regression
  Scenario: User search car rental successfully
    Given User navigate to the website
    And   User clicks on car rental button
    And   User type the car rental info
    When  User clicks on car rental hotel
    Then  User redirected to available car rental
#It is possible to hard code the inputs data