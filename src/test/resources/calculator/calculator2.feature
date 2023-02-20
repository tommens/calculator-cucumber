Feature: Integer Arithmetic Expressions

Background:
Given I initialise a calculator

  Scenario: Adding two integer numbers
    Given an integer operation '+'
    When I provide a first number 8
    And I provide a second number 6
    Then the operation evaluates to 14

  Scenario: Adding two integer numbers
    Given an integer operation '-'
    When I provide a first number 8
    And I provide a second number 6
    Then the operation evaluates to 2

  Scenario: Adding two integer numbers
    Given an integer operation '/'
    When I provide a first number 8
    And I provide a second number 6
    Then the operation evaluates to 1

  Scenario: Adding two integer numbers
    Given an integer operation '*'
    When I provide a first number 8
    And I provide a second number 6
    Then the operation evaluates to 48

  Scenario: Printing the sum of two integer numbers
    Given the sum of two numbers 8 and 6
    Then its INFIX notation is ( 8 + 6 )
    And its PREFIX notation is + (8, 6)
    And its POSTFIX notation is (8, 6) +

  Scenario: Printing the difference of two integer numbers
    Given the difference of two numbers 8 and 6
    Then its INFIX notation is ( 8 - 6 )
    And its PREFIX notation is - (8, 6)
    And its POSTFIX notation is (8, 6) -

  Scenario: Printing the product of two integer numbers
    Given the product of two numbers 8 and 6
    Then its INFIX notation is ( 8 * 6 )
    And its PREFIX notation is * (8, 6)
    And its POSTFIX notation is (8, 6) *

  Scenario: Printing the quotient of two integer numbers
    Given the quotient of two numbers 8 and 6
    Then its INFIX notation is ( 8 / 6 )
    And its PREFIX notation is / (8, 6)
    And its POSTFIX notation is (8, 6) /

