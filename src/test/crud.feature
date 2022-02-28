Feature: Make CRUD requests
  Users should be able to submit GET, POST PUT and DELETE
  requests to a web service

  Scenario: Create new Termo
    When a user sends a POST request
    Then the server should create and return the item
    Given the termo does not already exist

  Scenario: Request a Termo
    When a user sends a GET request for a specific ID
    Then the server should return the item
    Given it exists in the array

  Scenario: Update a Termo
    When a user sends a PUT request for a specific ID
    Then the server should update and return the item
    Given it exists in the array

  Scenario: Delete a Termo
    When a user sends a DELETE request for a specific ID
    Then the server should delete the item
    Given it exists in the array
