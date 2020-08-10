package stepDefinitions;

import io.cucumber.java.en.Then;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MarsAirMainPage;
import pages.SearchResultsPage;
import util.CommonActions;
import util.Constants;

public class InvalidReturnDates {

    private WebDriver driver = DriverFactory.getDriver();
    private MarsAirMainPage marsAirMainPage = new MarsAirMainPage(driver);
    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private CommonActions commonActions = new CommonActions(driver);

    @Then("an invalid return date message should be displayed")
    public void an_invalid_return_date_message_should_be_displayed() {
        String actualMsg = searchResultsPage.getSearchResultsMsg();

        Assert.assertEquals("Wrong Message!", Constants.INVALID_DATES_MSG, actualMsg);
    }
}
