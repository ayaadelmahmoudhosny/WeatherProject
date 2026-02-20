Feature: Change Time Format

  Scenario: Change time format from 24 to 12
    Given User in main page
    When User taps on time format button
    Then Time Format changes
    When User Clicks Done
    Then Rain and Humidity is shown

