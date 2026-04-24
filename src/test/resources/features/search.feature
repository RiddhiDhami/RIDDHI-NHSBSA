Feature: NHS Job Search

  Background:
    Given I am on NHS Jobs search page

  Scenario Outline: Search jobs by fill out NHS job search form and sort by newest
    When I enter job skill "<title>"
    And I enter location "<location>"
    And I select "<distance>" from the dropdown
    And I click on the Search button
    Then I will wait for search results to be displayed
    When I select "Date Posted (newest)" from the sort by dropdown
    Then the Job Title field should contain "<title>"
    And the Location field should contain "<location>"

    Examples:
      | title  | location | distance  |
      | Nurse  | London   | +5 Miles  |
      | Tester | watford  | +20 Miles |


  Scenario Outline: Search jobs by adding reference and sort by newest
    When I click on More search options
    And I enter job skill "<title>"
    And I enter location "<location>"
    And I select "<distance>" from the dropdown
    And I enter job reference "<jobReference>"
    And I enter employer "<employer>"
    And I select "<payRange>" from the Pay Range dropdown
    And I click on the Search button
    Then I will wait for search results to be displayed
    When I select "Date Posted (newest)" from the sort by dropdown
    Then The sort by dropdown should have "Date Posted (newest)" selected
    And Job skill field should contain "<title>"
    And Location field should contain "<location>"
    And Job Reference field should contain "<jobReference>"
    And Employer field should contain "<employer>"

    Examples:
      | title  | location   | distance  | jobReference  | employer                | payRange           |
      | Nurse  | London     | +5 Miles  | 304-9012511-1 | Medicus Health Partners | £20,000 to £30,000 |
      | Doctor | Birmingham | +20 Miles | A2961-26-0017 | NHS Foundation Trust    | £60,000 to £70,000 |

  Scenario: Search with all empty fields and default value in dropdown
    When I click on More search options
    And I enter "" in job title
    And I enter "" in location field
    And Distance dropdown selected "+5 Miles" by default
    And I enter "" in the job reference
    And I enter "" in the employer
    And I select "Please select" from the Pay Range dropdown
    And I click on search button
    Then I wait for search results to be displayed
    And I should see all available job results

  Scenario: Resets all search fields to default by clear filters option
    When I enter job skill "Nurse"
    And I enter location "London"
    And I select "+5 Miles" in the Distance dropdown
    And I click on the Clear filters button
    Then the Job Title field should be empty
    And the Location field should be empty
    And the Distance dropdown should be disabled and have "All locations" selected

  Scenario Outline: Enter Invalid inputs and verify error
    When I enter job skill "<title>"
    And I enter location "<location>"
    And I select "<distance>" in the Distance dropdown
    And I click on search button
    Then I should see error message "<expectedMessage>"

    Examples:
      | title | location | distance  | expectedMessage    |
      | Nurse | Londn    | +10 Miles | Location not found |
      | 123@  | London   | +50 Miles | No result found    |
      | 123@  | 12345678 | +10 Miles | No result found    |
      | Nurse | 12345678 | +10 Miles | Location not found |
