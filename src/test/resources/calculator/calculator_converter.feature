 Background:
    Given I initialise a calculator

  Scenario: Converting units of measurement
    Given a measurement 'Length' and a value 1
    When I provide a first unit "dm"
    And a second unit "dam"
    Then the conversion from "dm" to "dam" evaluates to 0.01

  Scenario Outline: Converting units of measurement
    Given a measurement 'Power' and a value 1
    When I provide a first unit "W"
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
    Given a measurement 'Time' and a value 1
    When I provide a first unit "<unit1>"
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
    Given a measurement '<measurement>' and a value <value>
    When I provide a first unit "<unit1>"
    And a second unit '<unit2>'
    Then the conversion from "<unit1>" to "<unit2> evaluates to <result>

    Examples:
      | measurement | value | unit1  | unit2  | result   |
      | Pressure    | 2     | Pa     | hPa    | 0.02     |
      | Energy      | 5     | PET    | J      | 2.0934e11|
      | Currency    | 10    | CNY    | $      | 1.4520   |
      | Area        | 20    | km2    | mm2    | 2e13     |