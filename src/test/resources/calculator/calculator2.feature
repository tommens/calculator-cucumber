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
    When I provide a first number 3
    And I provide a second number 6
    Then the operation evaluates to 0.5

  Scenario: Adding two integer numbers
    Given an integer operation '*'
    When I provide a first number 8
    And I provide a second number 6
    Then the operation evaluates to 48

  Scenario Outline: Adding two numbers with exp
    Given an integer operation <s>
    When I provide a first number with parameters <s1> and <arg0>
    And I provide a second number with parameters <s2> and <arg01>
    Then the operation evaluates to the number with parameters <arg02> and <arg1>
    Examples:
      | s   | s1  | arg0 | s2  | arg01 | arg02 | arg1 |
      | '+' | 1   | 2    | 1   | 3     | "1.1" | 3    |
      | '+' | 1   | 4    | 1   | 3     | "1.1" | 4    |
      | '-' | 1   | 2    | 1   | 3     | "-0.9"| 3    |
      | '-' | 1   | 4    | 1   | 3     | "0.9" | 4    |
      | '*' | 1   | 2    | 1   | 3     | "1"   | 5    |
      | '/' | 1   | 2    | 1   | 3     | "1"   | -1   |
      | '/' | 1   | 4    | 1   | 3     | "1"   | 1    |

  Scenario Outline: Equality of 2 numbers with exp
    Given two number with parameters <arg0> and <arg1> and <arg2> and <arg3>
    Examples:
      | arg0  | arg1  | arg2  | arg3 |
      | "1"   | 1     | "10"  | 0    |
      | "1"   | 0     | "10"  | -1   |
      | "10"  | 1     | "1"   | 2    |
      | "1"   | 2     | "10"  | 1    |
      | "1"   | 0     | "1"   | 0    |

  Scenario Outline: Equality of 1 number with special case
    Given one number with parameters <arg0> and <arg1>
    Examples:
      | arg0  | arg1  |
      | "1"   | 1     |
