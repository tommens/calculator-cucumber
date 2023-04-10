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


  Scenario Outline: Evaluating operations with two integer parameters
    Given an integer operation '<op>'
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then its INFIX notation is ( <n1> <op> <n2> )
    And its PREFIX notation is <op> (<n1>, <n2>)
    And its POSTFIX notation is (<n1>, <n2>) <op>

    Examples:
      |n1| op  |n2|
      |4| + | 5|
      |8| - | 5|
      |7| * | 2|
      |6| / | 2|