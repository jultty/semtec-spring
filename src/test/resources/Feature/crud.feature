Feature: Make CRUD requests
  Users should be able to submit GET, POST PUT and DELETE
  requests to a web service

  Scenario: Test response code for GET
    Given the endpoint is live
    When a GET request is made for ID 1
    Then the service should return code 200
