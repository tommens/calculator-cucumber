Feature: Time computation

  Scenario: Subtract two MyTime objects and get the duration
    Given I have two MyTime objects with dates "2023-04-15 10:30:00 +00:00" and "2023-04-15 11:45:00 +00:00"
    When I subtract the first MyTime object from the second MyTime object
    Then I should get the duration as "1 hours, 15 minutes and 0 seconds"

  Scenario: Add two MyTime objects and get the sum
    Given I have two MyTime objects with dates "2023-04-15 10:30:00 +00:00" and "2023-04-15 11:45:00 +00:00"
    When I add the first MyTime object to the second MyTime object
    Then I should get the sum as "2023-04-15 12:15:00 +00:00"

  Scenario: Subtract two MyTime objects with different timezones and get the duration
    Given I have two MyTime objects with dates "2023-04-15 10:30:00 +02:00" and "2023-04-15 11:45:00 -03:00"
    When I subtract the first MyTime object from the second MyTime object
    Then I should get the duration as "7 hours, 15 minutes and 0 seconds"

  Scenario: Add two MyTime objects with different timezones and get the sum
    Given I have two MyTime objects with dates "2023-04-15 10:30:00 +02:00" and "2023-04-15 11:45:00 -03:00"
    When I add the first MyTime object to the second MyTime object
    Then I should get the sum as "2023-04-15 14:15:00 +00:00"