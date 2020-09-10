Feature: GetOne Scenarios for Collection Endpoint

  Background:
    Given the path has a key "collections/"


  Scenario Outline: 1- make a get operation to [<UID>]
    And I make a GET request to "<UID>"
    And the response body has the following attributes with values
      | collection.info._postman_id | <id>          |
      | collection.info.name        | <name>        |
      | collection.info.description | <description> |
      | collection.info.schema      | <schema>      |

    Examples:
      | UID                                           | id                                   | name                  | description                       | schema                                                               |
      | 12667634-031b1210-5ad8-4137-bb18-6ddbcb06ff07 | 031b1210-5ad8-4137-bb18-6ddbcb06ff07 | Emmanuel's Collection | This is just a sample collection. | https://schema.getpostman.com/json/collection/v2.1.0/collection.json |
      | 12667634-7e098a13-7339-498b-81bd-473b8db4f13f | 7e098a13-7339-498b-81bd-473b8db4f13f | Sample Collection 629 | This is just a sample collection. | https://schema.getpostman.com/json/collection/v2.1.0/collection.json |
      | 12667634-9db8b3ad-b309-4854-b508-94d536da2b59 | 9db8b3ad-b309-4854-b508-94d536da2b59 | Emmanuel's Collection | This is just a sample collection. | https://schema.getpostman.com/json/collection/v2.1.0/collection.json |

  @RunThis
  Scenario: 2- Try to get an unexisting collection
    And I make a GET request to "12667634-031b1210-5ad8-4137-bb18-6ddbcb06ff98"
    Then the response Http code is "404"
    And the response body has the following attributes with values
      | error.name    | instanceNotFoundError                                |
      | error.message | We could not find the collection you are looking for |



