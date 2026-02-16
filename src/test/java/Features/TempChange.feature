Feature: Change Temperature Unit

  Scenario: Change temperature unit from C to F
    Given User in main page
    When User tap on temperature button
    Then Temperature change from C to F
    Then TimeFormat to twelve
    When User Clicks Done
    Then Rain and Humidity is shown

