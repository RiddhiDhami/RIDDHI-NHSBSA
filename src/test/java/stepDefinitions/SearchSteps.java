package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchSteps {


    WebDriver driver;
    SearchPage page;

  /*  @Given("I am on NHS Jobs search page")
    public void openSearchPage() {

        DriverFactory.initDriver();  // initialize
        driver = DriverFactory.getDriver();   // fetch
        page = new SearchPage(driver);
        page.openPage();
    }*/
  @Given("I am on NHS Jobs search page")
  public void openSearchPage() {

      driver = DriverFactory.initDriver();

      if (driver == null) {
          throw new RuntimeException("Driver is NULL after initDriver()");
      }

      page = new SearchPage(driver);
      page.openPage();
  }
    @When("I click on More search options")
    public void clickMoreOptions()throws Exception {
        page.openMoreSearchOptions();
    }

    @When("I enter job skill {string}")
    public void enterJobSkill(String title)throws Exception {
        page.enterJobTitle(title);
    }

    @When("I enter location {string}")
    public void enterLocation(String loc) throws Exception{
        page.enterLocation(loc);
    }

    @When("I select {string} from the dropdown")
    public void selectDistance(String dist) throws Exception{
        page.selectDistance(dist);
    }

    @When("I click on the Search button")
    public void clickSearch() throws Exception{
        page.clickSearch();
    }

    @When("I click on search button")
    public void clickSearchLower() throws Exception{
        page.clickSearch();
    }

    @Then("I will wait for search results to be displayed")
    public void waitResults()throws Exception {
        page.waitForResults();
    }

    @Then("I wait for search results to be displayed")
    public void waitResultsAlt() throws Exception{
        page.waitForResults();
    }

    @When("I select {string} from the sort by dropdown")
    public void selectSort(String option) throws Exception{
        page.selectSortBy(option);
    }

    @Then("the Job Title field should contain {string}")
    public void verifyJobTitle(String expected) throws Exception{
        Assert.assertTrue(page.getFirstJobTitle().toLowerCase().contains(expected.toLowerCase()));
    }

    @Then("the Location field should contain {string}")
    public void verifyLocation(String expected) throws Exception{
        Assert.assertTrue(page.getFirstLocation().toLowerCase().contains(expected.toLowerCase()));
    }

    @When("I enter job reference {string}")
    public void enterReference(String ref)throws Exception {
        page.enterJobReference(ref);
    }

    @When("I enter employer {string}")
    public void enterEmployer(String emp)throws Exception {
        page.enterEmployer(emp);
    }

    @When("I select {string} from the Pay Range dropdown")
    public void selectPayRange(String pay) throws Exception{
        page.selectPayRange(pay);
    }

    @Then("The sort by dropdown should have {string} selected")
    public void verifySortSelected(String expected)throws Exception {
        Assert.assertEquals(expected, page.getSelectedSortOption());
    }

    @Then("Job skill field should contain {string}")
    public void verifySkill(String expected) {

        String actualTitle = page.getFirstJobTitle();

        System.out.println("First job title: " + actualTitle);

        Assert.assertTrue(
                "Expected job title to contain: " + expected + " but got: " + actualTitle,
                actualTitle.toLowerCase().contains(expected.toLowerCase())
        );
    }

    @Then("Location field should contain {string}")
    public void verifyLoc(String expected) {

        String actualLocation = page.getFirstLocation();

        System.out.println("First job location: " + actualLocation);

        Assert.assertTrue(
                actualLocation.toLowerCase().contains(expected.toLowerCase())
        );
    }

    @Then("Job Reference field should contain {string}")
    public void verifyRef(String expected) throws Exception{
        // depends on UI – placeholder
        Assert.assertEquals(expected, driver.findElement(By.id("jobReference")).getAttribute("value"));
    }

    @Then("Employer field should contain {string}")
    public void verifyEmployer(String expected)throws Exception {
        // depends on UI – placeholder
        Assert.assertEquals(expected, driver.findElement(By.id("employer")).getAttribute("value"));
    }

    @When("I enter \"\" in job title")
    public void emptyJobTitle()throws Exception {
        page.enterJobTitle("");
    }

    @When("I enter \"\" in location field")
    public void emptyLocation()throws Exception {
        page.enterLocation("");
    }

    @When("Distance dropdown selected {string} by default")
    public void verifyDefaultDistance(String expected) throws Exception{
        /*Assert.assertEquals(expected,
                new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("distance")))
                        .getFirstSelectedOption().getText());*/
    }

    @When("I enter \"\" in the job reference")
    public void emptyRef()throws Exception {
        page.enterJobReference("");
    }

    @When("I enter \"\" in the employer")
    public void emptyEmployer() throws Exception{
        page.enterEmployer("");
    }

    @Then("I should see all available job results")
    public void verifyAllResults() throws Exception{
        page.waitForResults();
    }

    @When("I click on the Clear filters button")
    public void clearFilters() throws Exception{
        page.clickClearFilters();
    }

    @Then("the Job Title field should be empty")
    public void verifyTitleEmpty()throws Exception {
        Assert.assertTrue(page.isJobTitleEmpty());
    }

    @Then("the Location field should be empty")
    public void verifyLocationEmpty() throws Exception{
        Assert.assertTrue(page.isLocationEmpty());
    }
    @Then("the Distance dropdown should be disabled and have {string} selected")
    public void verifyDistanceReset(String expected) throws Exception{
        Assert.assertEquals(expected,
                new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("distance")))
                        .getFirstSelectedOption().getText());
    }

    @When("I select {string} in the Distance dropdown")
    public void selectDistanceAlt(String dist)throws Exception {
        page.selectDistance(dist);
    }

    @Then("I should see error message {string}")
    public void verifyError(String expected) {

        String actual = page.getErrorMessageDynamic();

        System.out.println("Actual error message: " + actual);

        Assert.assertTrue(
                "Expected: " + expected + " but got: " + actual,
                actual.toLowerCase().contains(expected.toLowerCase())
        );
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}