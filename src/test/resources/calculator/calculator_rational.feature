Feature: Rational Arithmetic Expressions
  This feature provides a range of scenarios corresponding to the
  intended external behaviour of arithmetic expressions on rational numbers.


  Background:
    Given I initialise a calculator



  Scenario Outline: Writing the different operations in the different notations
    Given an operation <op>
    When I provide a first rational number <n1>_/<d1>
    And I provide a second rational number <n2>_/<d2>
    Then its PREFIX notation is <prefix_result>
    And its POSTFIX notation is <postfix_result>
    And its INFIX notation is <infix_result>


    Examples:
      | op  | n1 | d1 | n2 | d2 | prefix_result  | postfix_result | infix_result    |
      | "+" | 4  | 5  | 2  | 3  | + (4_/5, 2_/3) | (4_/5, 2_/3) + | ( 4_/5 + 2_/3 ) |
      | "-" | 4  | 5  | 2  | 3  | - (4_/5, 2_/3) | (4_/5, 2_/3) - | ( 4_/5 - 2_/3 ) |
      | "*" | 4  | 5  | 2  | 3  | * (4_/5, 2_/3) | (4_/5, 2_/3) * | ( 4_/5 * 2_/3 ) |
      | "/" | 4  | 5  | 2  | 3  | / (4_/5, 2_/3) | (4_/5, 2_/3) / | ( 4_/5 / 2_/3 ) |

  Scenario Outline: Evaluating arithmetic operations with two rational parameters
    Given an operation <op>
    When I provide a first rational number <n1>_/<d1>
    And I provide a second rational number <n2>_/<d2>
    Then the operation evaluates to rational <result>

    Examples:
      | op  | n1 | d1 | n2 | d2 | result   |
      | "+" | 4  | 5  | 2  | 3  | "22_/15" |
      | "-" | 4  | 5  | 2  | 3  | "2_/15"  |
      | "*" | 4  | 5  | 2  | 3  | "8_/15"  |
      | "/" | 4  | 5  | 2  | 3  | "6_/5"   |