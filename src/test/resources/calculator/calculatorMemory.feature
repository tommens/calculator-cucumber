Feature: Integer Arithmetic Expressions

Background:
Given I initialise a calculator

  Scenario: Adding a variable in memory
    Given an integer operation '+'
    Given a memory in the calculator of size 100
    When I provide a first number 8
    And I provide a second number 6
    And I create a variable x containing above data and I store it in memory
    Then the calculator memory contains a variable x with value 14

  Scenario: Removing a variable in memory
    Given an integer operation '+'
    Given a memory in the calculator of size 100
    When I provide a first number 8
    And I provide a second number 6
    And I create a variable x containing above data and I store it in memory
    When I remove the variable x from memory
    Then the calculator memory does not contain a variable x