Feature: Ticket

  Scenario Outline: User can provide Connection info and gets search with those parameters
    Given User opens SBB Homepage
    When user sets from "<from>"
    And user sets to "<to>"
    And User sets via "<via>"
    And User sets date "<date>"
    And user sets time "<time>"
    And user sets dep_arr "<dep_arr>"
    And user starts search
    Then user gets connections
    And connection date is "<date>"
    And connection time is "<time>"
    And connection from is "<from>"
    And connection to is "<to>"
    And connection via is "<via>"

    Examples:
      | from | to      | via      | date       | time  | dep_arr |
      | Bern | Ittigen | Bolligen | 30.03.2022 | 13:00 | ab      |