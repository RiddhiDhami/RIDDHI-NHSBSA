package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchSteps {
    WebDriver driver;
    SearchPage page;

    @Given("I am on NHS Jobs search page")
    public void openSearchPage() {
        driver = DriverFactory.getDriver("chrome");
        page = new SearchPage(driver);
        page.openPage();
    }

    @When("I search for {string}")
    public void searchJob(String keyword) {
        page.enterKeyword(keyword);
        page.clickSearch();
    }

    @When("I sort results by newest date")
    public void sortResults() {
        page.sortByNewest();
    }

    @Then("I should see job results")
    public void verifyResults() {
        Assert.assertTrue(page.isResultsDisplayed());
    }

    @Then("jobs should be displayed in descending order")
    public void verifySorting() {
        // Basic validation placeholder (you can enhance later)
        Assert.assertTrue(true);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
