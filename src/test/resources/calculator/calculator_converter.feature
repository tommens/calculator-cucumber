Feature: Conversion of measurement units

  # This is just a comment.
  # You can start with a Background: that will be run before executing each scenario.

  Background:
    Given I initialise a calculator

  Scenario: Converting units of measurement
    Given a measurement 'Length' and a first unit "dm"
    When I provide a value 1
    And a second unit "dam"
    Then the conversion from "dm" to "dam" evaluates to 0.01

  Scenario Outline: Converting units of measurement
    Given a measurement 'Power' and a first unit "W"
    When I provide a value 1
    And a second unit '<unit>'
    Then the conversion from "W" to "<unit>" evaluates to <result>

    Examples:
      |unit|result           |
      |kW  |0.001            |
      |MW  |0.000001         |
      |GW  |0.000000001      |
      |TW  |0.000000000001   |
      |PW  |0.000000000000001|

 Scenario Outline: Converting units of measurement
    Given a measurement 'Time' and a first unit "<unit1>"
    When I provide a value 1
    And a second unit '<unit2>'
    Then the conversion from "<unit1>" to "<unit2>" evaluates to <result>

    Examples:
      |unit1|unit2|result |
      |ms   |s    |0.001  |
      |mn   |ms   |60000.0|
      |h    |wk   |0.005952  |
      |d    |yr   |0.002739379  |
      |wk   |d    |7.0    |
      |yr   |h    |8761.111111111 |

 Scenario Outline: Converting units of measurement
    Given a measurement '<measurement>' and a first unit "<unit1>"
    When I provide a value <value>
    And a second unit '<unit2>'
    Then the conversion from "<unit1>" to "<unit2>" evaluates to <result>

    Examples:
      | measurement | value | unit1  | unit2  | result         |
      | Pressure    | 2     | Pa     | hPa    | 0.02           |
      | Energy      | 5     | PET    | J      |209340000000.0  |
      | Currency    | 10    | CNY    | $      | 1.452064539    |
      | Area        | 20    | km2    | mm2    |20000000000000.0|