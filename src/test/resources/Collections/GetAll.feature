Feature: GetAll Scenarios for POSTMAN API


  Scenario: 1- Try to GetAll "collections" and verify base attributes exists
    And I make a GET request to "collections"
    Then the response has a field of "collections"
    And the response body has the following attributes
      | collections          |
      | collections[*].id    |
      | collections[*].name  |
      | collections[*].owner |
      | collections[*].uid   |


  Scenario: 2- Try to GetAll "collections" using an invalid endpoint
    And I make a GET request to "invalid"
    Then the response Http code is "404"
    And the response body has the following attributes with values
      | error.name    | notFound                     |
      | error.message | Requested resource not found |

    
