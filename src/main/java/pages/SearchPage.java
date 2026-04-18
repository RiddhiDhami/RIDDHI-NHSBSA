package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By keywordBox = By.id("keyword");
    By searchButton = By.id("search");
    By sortDropdown = By.id("sort");
    By results = By.cssSelector("li.search-result");

    public void openPage() {
        driver.get("https://www.jobs.nhs.uk/candidate/search");
    }

    public void enterKeyword(String keyword) {
        driver.findElement(keywordBox).sendKeys(keyword);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void sortByNewest() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Date Posted (newest)");
    }

    public boolean isResultsDisplayed() {
        return driver.findElements(results).size() > 0;
    }

    public List<WebElement> getResults() {
        return driver.findElements(results);
    }

}
