# RIDDHI-NHSBSA

# 🧪 NHS Job Search Automation Framework

## 📌 Overview

This project is an automated test framework built to validate the NHS Jobs Search functionality based on the provided user story and acceptance criteria.

The framework ensures that a jobseeker can:

* Search for jobs using preferences (job title, location, distance)
* Apply additional filters (job reference, employer, pay range)
* View relevant job results
* Sort results by newest date posted

The framework is designed using Selenium WebDriver, Cucumber (BDD), Java, and Maven, following the Page Object Model (POM) design pattern.

---

# 🎯 User Story

> As a jobseeker on NHS Jobs website
> I want to search for a job with my preferences
> So that I can get recently posted job results

---

# ✅ Acceptance Criteria

The following acceptance criteria were used to design test cases:

* User should be able to:

    * Enter job title (skill)
    * Enter location
    * Select distance from dropdown
* User should be able to search using:

    * Job reference
    * Employer
    * Pay range
* System should:

    * Display job results matching user preferences
    * Allow sorting results by Date Posted (newest)
* System should handle:

    * Invalid inputs (e.g., special characters)
    * Invalid location (e.g., "Londn")
    * No results scenario
    * Empty field search
* User should be able to:

    * Reset filters using "Clear filters"

---

# 🧪 Test Coverage

The feature file includes the following test scenarios:

## ✔ Positive Scenarios

* Search jobs using valid inputs
* Search jobs using advanced filters
* Sort job results by newest

## ✔ Negative Scenarios

* Invalid location → *"Location not found"*
* Invalid job skill → *"No result found"*

## ✔ Edge Cases

* Search with empty fields
* Validate default dropdown values
* Clear filters functionality
* Verify input field persistence after search

---

# 🛠️ Tools & Technologies Used

* **Java (JDK 24)**
* **Selenium WebDriver (4.21.0)**
* **Cucumber (BDD Framework)**
* **JUnit**
* **Maven**
* **WebDriverManager**
* **IntelliJ IDEA**

---

# 🏗️ Framework Design

The project follows:

* **Page Object Model (POM)** → separates UI locators and actions
* **BDD (Behavior Driven Development)** → readable test scenarios
* **Reusable Components** → DriverFactory, Page classes

---

# 📁 Project Structure

src
 └── test
     ├── java
     │   ├── pages
     │   │    └── SearchPage.java        # Page Object (UI actions & locators)
     │   │
     │   ├── stepDefinitions
     │   │    └── SearchSteps.java      # Step Definitions (BDD steps)
     │   │
     │   ├── runners
     │   │    └── TestRunner.java       # Test Runner
     │   │
     │   └── utils
     │        └── DriverFactory.java    # WebDriver management
     │
     └── resources
         └── features
              └── search.feature       # Feature file (BDD scenarios)
```

---
# ⚙️ Prerequisites

Before running the project, ensure the following are installed:

* Java (JDK 11 or higher recommended)
* Maven
* Chrome Browser
* Internet connection (for WebDriverManager)

---

# 🚀 How to Run the Tests

## 🔹 Step 1: Clone the Repository

git clone <your-repository-url>
cd <your-project-folder>

## 🔹 Step 2: Run Tests Using Maven

mvn clean test

---

## 🔹 Step 3: View Test Report

After execution, open:
target/cucumber-report.html

This will display the execution results with scenario details.

---

# 🔄 Test Execution Flow

Feature file → Step Definitions → Page Object → WebDriver → Application

---

# ⚠️ Challenges & Solutions

### ✔ Dynamic Error Handling

Handled multiple error messages:

* "Location not found"
* "No result found"

### ✔ Synchronization Issues

Resolved using:

* `WebDriverWait`
* Explicit waits

### ✔ Browser Lifecycle Issues

Fixed using:

* Proper driver initialization
* `@After` hook for closing browser

---

# 🚀 Future Enhancements

  Add Hooks class for better test lifecycle management
  Implement Parallel Execution
  Integrate Allure Reporting
  Add CI/CD pipeline (Jenkins/GitHub Actions)
  Add Cross-browser testing (Edge, Safari)
  Externalize test data (Excel / JSON)
  Add logging using Log4j or SLF4J binding
  Implement retry mechanism for flaky tests



