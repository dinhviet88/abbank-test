@ui
Feature: Application Under Test

  Scenario: Successfully create a new user
    Given  open the OrangeHRM login page
    And  login using default credentials
    When  navigate to Admin User Management
    And  create a new user with valid information
    Then  verify that the user has been created successfully
    When  search for the newly created user using the username
    Then should see the user listed in the search results
