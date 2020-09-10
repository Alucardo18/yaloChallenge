Feature: Delete Scenarios for Collection Endpoint[hostname/Collections/{UUID}]

  Background:
    Given the path has a key "collections/"
@Ignore
  Scenario: 1-Delete one existing collection
    And I remove a collection with UID "12667634-07e4af98-7b6a-4c1e-b2c0-470de51aa413"
    Then the response Http code is "200"


  Scenario: 2-Try to delete an unexisting record
    And I remove a collection with UID "12667634-07e4af98-7b6a-4c1e-b2c0-470de599999"
    Then the response Http code is "404"
    And the response body has the following attributes with values
      | error.name    | instanceNotFoundError              |
      | error.message | The specified item does not exist. |