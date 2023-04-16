Feature: Time computation

  Scenario: Adding two dates
    Given I have two MyTime objects with dates "2023-04-16" and "2023-04-15"
    When I add the first MyTime object to the second MyTime object
    Then I should get the sum as "2076-07-28T02:00Z"

  Scenario: Adding two dates with time formats
    Given I have two MyTime objects with dates "2022-05-17 05:30:00 am" and "2022-05-17 11:45:00 pm"
    When I add the first MyTime object to the second MyTime object
    Then I should get the sum as "2023-04-15 14:15:00 +00:00"

  Scenario: Adding two dates with time formats and different timezones
    Given I have two MyTime objects with dates "2023-04-15 10:30:00 +02:00" and "2023-04-15 11:45:00 -03:00"
    When I add the first MyTime object to the second MyTime object
    Then I should get the sum as "2023-04-15 14:15:00 +00:00"