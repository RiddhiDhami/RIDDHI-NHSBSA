Feature: NHS Job Search

  Scenario: Search jobs using keyword and sort by newest
    Given I am on NHS Jobs search page
    When I search for "Tester"
    And I sort results by newest date
    Then I should see job results
    And jobs should be displayed in descending order