Feature: Testing LIBUltra Util services

  @RegularTest
  Scenario: Float points are equal
    Given I have two same floating point numbers
    When I compare them
    Then they are equal return true

  @RegularTest
  Scenario: Float points are not the same
    Given I have two different floating point numbers
    When I compare them again
    Then they are not equal return false