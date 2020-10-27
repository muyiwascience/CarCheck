Feature: As a user i want to be able to use search for cars with reg number

  @working
  Scenario: Searching with the DN09HRM
    Given I verify current url
    When I perform search on the first registration number DN09HRM
    And i verify that i am on the search result page
    Then I verify car details match with output text data for DN09HRM

  @working
  Scenario: Searching with the BW57BOW
    Given I verify current url
    When I perform search on the second registration number BW57BOW
    And i verify that i am on the search result page
    Then I verify car details match with output text data for BW57BOW

 @working
  Scenario: Searching with the KT17DLX
    Given I verify current url
    When I perform search on the third registration number KT17DLX
    And i verify that i am on the search result page
    Then I verify car details match with output text data for KT17DLX

 @working
  Scenario: Searching with the SG18HTN
    Given I verify current url
    When I perform search on the fourth registration number SG18HTN
    And i verify that i am on the search result page
    Then I verify car details match with output text data for SG18HTN


