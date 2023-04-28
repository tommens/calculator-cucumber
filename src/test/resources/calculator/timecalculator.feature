Feature: Time computation

  Background:
    Given I initialise a calculator

  Scenario: Subtracting a number to a date
    Given A MyTime object with date "2020-03-03 15:30:00"
    When I provide a number to subtract 3600
    Then the result is "2020-03-03 14:30:00"

  Scenario: Adding a number to a date
    Given A MyTime object with date "2020-03-03 15:30:00"
    When I provide a number to add 3600
    Then the result is "2020-03-03 16:30:00"