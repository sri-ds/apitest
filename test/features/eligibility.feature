Feature: Eligibility
  An example of testing Clojure with cucumber. To see a failure try changing
  the last 'Then' of 'eat 1 cuke' "meh" to "happy".

Scenario: Eligibility test for San Diego
    Given I have street "2621 Collier Ave" city "San Diego" state "CA" zip "92116"
    When I check eligibility
    Then I am eligible for "eligible" "ineligible" "eligible"

Scenario: Eligibility test for LA
    Given I have street "3425 Federal Ave" city "Los Angeles" state "CA" zip "90066"
    When I check eligibility
    Then I am eligible for "eligible" "eligible" "eligible"

Scenario: Eligibility test for New York Address
    Given I have street "25 Bedford St" city "New York City" state "NY" zip "10014"
    When I check eligibility
    Then I am eligible for "eligible" "ineligible" "ineligible"
