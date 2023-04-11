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
      |unit|result|
      |kW  |1e-3  |
      |MW  |1e-6  |
      |GW  |1e-9  |
      |TW  |1e-12 |
      |PW  |1e-15 |

 Scenario Outline: Converting units of measurement
    Given a measurement 'Time' and a first unit "<unit1>"
    When I provide a value 1
    And a second unit '<unit2>'
    Then the conversion from "<unit1>" to "<unit2>" evaluates to <result>

    Examples:
      |unit1|unit2|result |
      |ms   |s    |1e-3   |
      |mn   |ms   |60000  |
      |h    |wk   |168    |
      |d    |yr   |365    |
      |wk   |d    |7      |
      |yr   |h    |8760   |

 Scenario Outline: Converting units of measurement
    Given a measurement '<measurement>' and a first unit "<unit1>"
    When I provide a value <value>
    And a second unit '<unit2>'
    Then the conversion from "<unit1>" to "<unit2> evaluates to <result>

    Examples:
      | measurement | value | unit1  | unit2  | result   |
      | Pressure    | 2     | Pa     | hPa    | 0.02     |
      | Energy      | 5     | PET    | J      | 2.0934e11|
      | Currency    | 10    | CNY    | $      | 1.4520   |
      | Area        | 20    | km2    | mm2    | 2e13     |