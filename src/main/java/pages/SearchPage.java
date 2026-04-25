package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        if (driver == null) {
            throw new RuntimeException("Driver is NULL in SearchPage constructor!");
        }
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By jobTitle = By.id("keyword");
    By location = By.id("location");
    By distance = By.id("distance");
    By searchBtn = By.id("search");
    By results = By.cssSelector(".search-result");
    By moreSearchOptions = By.linkText("More search options");
    By jobReference = By.id("jobReference");
    By employer = By.id("employer");
    By payRange = By.id("payRange");
    By clearFilters = By.id("clearFilters");
    By sortBy = By.id("sort");
    //By errorMessage = By.cssSelector(".error-message");
    By noResultsTitle = By.id("no-result-title");
    By locationNotFound = By.cssSelector("h2[data-test='search-result-query']");

    // Result fields
    By firstJobTitle = By.id("first-result-title");
    By firstLocation = By.id("location");
    public void openPage() {
        driver.get("https://www.jobs.nhs.uk/candidate/search");
    }


    // Actions
    public void openMoreSearchOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(moreSearchOptions)).click();
    }

    public void enterJobTitle(String title) {
        driver.findElement(jobTitle).clear();
        driver.findElement(jobTitle).sendKeys(title);
    }

    public void enterLocation(String loc) {
        driver.findElement(location).clear();
        driver.findElement(location).sendKeys(loc);
    }

    public void selectDistance(String value) {
        new Select(driver.findElement(distance)).selectByVisibleText(value);
    }

    public void enterJobReference(String ref) {
        driver.findElement(jobReference).clear();
        driver.findElement(jobReference).sendKeys(ref);
    }

    public void enterEmployer(String emp) {
        driver.findElement(employer).clear();
        driver.findElement(employer).sendKeys(emp);
    }

    public void selectPayRange(String value) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payRange)
        );

        Select select = new Select(dropdown);

        // Normalize and find exact match
        for (WebElement option : select.getOptions()) {
            String text = option.getText().trim();

            if (text.equalsIgnoreCase(value.trim())) {
                option.click();
                return;
            }
        }

        // If not found → fail clearly
        throw new NoSuchElementException("Pay range option not found: " + value);
    }

    public void clickSearch() {
        driver.findElement(searchBtn).click();
    }

    public void clickClearFilters() {
        driver.findElement(clearFilters).click();
    }

    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(results));
    }

    public void selectSortBy(String value) {
        new Select(driver.findElement(sortBy)).selectByVisibleText(value);
    }

    // Getters
    public String getFirstJobTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstJobTitle));

        // ALSO wait until keyword field is populated again (important)
        wait.until(driver -> !driver.findElement(jobTitle).getAttribute("value").isEmpty());

        return driver.findElement(jobTitle).getAttribute("value");
    }


    public String getFirstLocation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstLocation));

        wait.until(driver -> !driver.findElement(location).getAttribute("value").isEmpty());

        return driver.findElement(location).getAttribute("value");
    }

    public String getSelectedSortOption() {
        return new Select(driver.findElement(sortBy)).getFirstSelectedOption().getText();
    }

//    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
//    }
public String getErrorMessageDynamic() {

    // Check "No result found"
    if (driver.findElements(noResultsTitle).size() > 0) {
        return driver.findElement(noResultsTitle).getText().trim();
    }

    // Check "Location not found"
    if (driver.findElements(locationNotFound).size() > 0) {
        return driver.findElement(locationNotFound).getText().trim();
    }

    return "";
}

    public boolean isJobTitleEmpty() {
        return driver.findElement(jobTitle).getAttribute("value").isEmpty();
    }

    public boolean isLocationEmpty() {
        return driver.findElement(location).getAttribute("value").isEmpty();
    }
}