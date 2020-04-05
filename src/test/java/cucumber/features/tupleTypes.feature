Feature: Tuples and their subtypes

  @RegularTest
  Scenario: Creating a Tuple
    Given I have no tuple
    When I create a tuple
    Then I have a tuple

  @RegularTest
  Scenario: Create a Point
    Given I have no point
    When I create a point
    Then I have a point

  @RegularTest
  Scenario: Create a Vector
    Given I have no vector
    When I create a vector
    Then I have a vector

  @RegularTest
  Scenario: Using Tuple factory
    Given I have not point or vector
    When I use the Tuple Factory
    Then I can create a Point and Vector

