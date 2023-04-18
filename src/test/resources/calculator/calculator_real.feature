Feature: Real Numbers Arithmetic Expressions
  This feature provides a range of scenarios corresponding to the
  intended external behaviour of arithmetic expressions on real numbers.

  Background:
    Given I initialise a calculator

  Scenario Outline: Evaluating arithmetic operations with two integer parameters
    Given an operation <op>
    When I provide a first real number <n1>
    And I provide a second real number <n2>
    Then the result of the operation is <result>

    Examples:
      | op  |n1       |n2     |result   |
      | "+" | "3.14"  | "2.75"| "5.89"  |
      | "-" | "8.933" | "5.2" | "3.733" |
      | "*" | "7.45"  | "2.1" | "15.645"|
      | "/" | "6.5"   | "2"   | "3.25"  |