Feature: create a new collection


  Background:
    Given the path has a key "collections/"


  Scenario: 1- Create a new collection
    When I create a new collection with body:
      """
      {
  "collection": {
    "info": {
      "name": "Emmanuel's Collection",
      "description": "This is just a sample collection.",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
      {
        "name": "This is a folder",
        "item": [
          {
            "name": "Sample POST Request",
            "request": {
              "url": "https://postman-echo.com/post",
              "method": "POST",
              "header": [
                {
                  "key": "Content-Type",
                  "value": "application/json"
                }
              ],
              "body": {
                "mode": "raw",
                "raw": "{\"data\": \"123\"}"
              },
              "description": "This is a sample POST Request"
            }
          }
        ]
      },
      {
        "name": "Sample GET Request",
        "request": {
          "url": "https://postman-echo/get",
          "method": "GET",
          "description": "This is a sample GET Request"
        }
      }
    ]
  }
}
      """
    And the response Http code is "200"
    And the response body has the following attributes with values
      | collection.name | Emmanuel's Collection |
    And I save the "collection.uid" identifier


  Scenario: 2- Try to create a new collection with a malformed JSON body
    When I create a new collection with body:
      """
      {
  "collection": {{}+}¡-*/-
    "info": {
      "name": "Emmanuel's Collection",
      "description": "This is just a sample collection.",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
      {
        "name": "This is a folder",
        "item": [
          {
            "name": "Sample POST Request",
            "request": {
              "url": "https://postman-echo.com/post",
              "method": "POST",
              "header": [
                {
                  "key": "Content-Type",
                  "value": "application/json"
                }
              ],
              "body": {
                "mode": "raw",
                "raw": "{\"data\": \"123\"}"
              },
              "description": "This is a sample POST Request"
            }
          }
        ]
      },
      {
        "name": "Sample GET Request",
        "request": {
          "url": "https://postman-echo/get",
          "method": "GET",
          "description": "This is a sample GET Request"
        }
      }
    ]
  }
}
      """
    And the response Http code is "500"


  Scenario: 3- Try to create a new collection with a malformed JSON body
    When I create a new collection with body:
      """
      {
  "collection": {{}+}¡-*/-
    "info": {
      "name": "Emmanuel's Collection",
      "description": "This is just a sample collection.",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
      {
        "name": "This is a folder",
        "item": [
          {
            "name": "Sample POST Request",
            "request": {
              "url": "https://postman-echo.com/post",
              "method": "POST",
              "header": [
                {
                  "key": "Content-Type",
                  "value": "application/json"
                }
              ],
              "body": {
                "mode": "raw",
                "raw": "{\"data\": \"123\"}"
              },
              "description": "This is a sample POST Request"
            }
          }
        ]
      },
      {
        "name": "Sample GET Request",
        "request": {
          "url": "https://postman-echo/get",
          "method": "GET",
          "description": "This is a sample GET Request"
        }
      }
    ]
  }
}
      """
    And the response Http code is "500"


  Scenario: 4- Try to create a new record with a malformed endpoint
    Given the path has a key "invalid"
    When I create a new collection with body:
      """
      {
  "collection": {
    "info": {
      "name": "Emmanuel's Collection",
      "description": "This is just a sample collection.",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
      {
        "name": "This is a folder",
        "item": [
          {
            "name": "Sample POST Request",
            "request": {
              "url": "https://postman-echo.com/post",
              "method": "POST",
              "header": [
                {
                  "key": "Content-Type",
                  "value": "application/json"
                }
              ],
              "body": {
                "mode": "raw",
                "raw": "{\"data\": \"123\"}"
              },
              "description": "This is a sample POST Request"
            }
          }
        ]
      },
      {
        "name": "Sample GET Request",
        "request": {
          "url": "https://postman-echo/get",
          "method": "GET",
          "description": "This is a sample GET Request"
        }
      }
    ]
  }
}
      """
  Then the response Http code is "404"
  And the response body has the following attributes with values
    | error.name    | notFound                     |
    | error.message | Requested resource not found |
