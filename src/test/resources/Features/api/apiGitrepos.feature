@api
Feature: Analyze SeleniumHQ repositories

  Scenario: Get total open issues and highest stars
    Given get all repositories from SeleniumHQ
    When calculate total open issues
    And find repository with highest stars
    Then print the result