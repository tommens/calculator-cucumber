Feature: Integer Arithmetic Expressions
  This feature provides a range of scenarios corresponding to the
  intended external behaviour of arithmetic expressions on integers.

  # This is just a comment.
  # You can start with a Background: that will be run before executing each scenario.

  Background:
    Given I initialise a calculator

  # Each scenario can be seen as a test that can be executed with JUnit,
  # provided that each of the steps (Given, When, And and Then) are
  # implemented in a Java mapping file (CalculatorSteps.Java)


  Scenario Outline: Writing the different operations in the different notations
    Given an operation <op>
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then its PREFIX notation is <prefix_result>
    And its POSTFIX notation is <postfix_result>
    And its INFIX notation is <infix_result>


    Examples:
      | op  | n1 |  | n2 | prefix_result | postfix_result | infix_result |
      | "+" | 8  |  | 6  | + (8, 6)      | (8, 6) +       | ( 8 + 6 )    |
      | "-" | 8  |  | 6  | - (8, 6)      | (8, 6) -       | ( 8 - 6 )    |
      | "*" | 8  |  | 6  | * (8, 6)      | (8, 6) *       | ( 8 * 6 )    |
      | "/" | 8  |  | 6  | / (8, 6)      | (8, 6) /       | ( 8 / 6 )    |