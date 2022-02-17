Feature: Order

  Scenario Outline: itil user can order in service portal
    Given itil user is logged in to service portal
    When itil user orders <order>
    Then Request has been created for <order>

    Examples:
      | order                    |
      | "Netzelement Modify 2.4" |