package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MarsAirMainPage;
import pages.SearchResultsPage;
import util.CommonActions;
import util.Constants;

public class BasicSearchFlow {

    private WebDriver driver = DriverFactory.getDriver();
    private MarsAirMainPage marsAirMainPage = new MarsAirMainPage(driver);
    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private CommonActions commonActions = new CommonActions(driver);

    @Given("user is in the home page")
    public void user_is_in_the_home_page() {
        marsAirMainPage.accessMainPage();
    }

    @Then("departure field should be available")
    public void departure_field_should_be_available() {
        Assert.assertTrue(marsAirMainPage.hasDepartureField());
    }

    @Then("return field should be available")
    public void return_field_should_be_available() {
        Assert.assertTrue(marsAirMainPage.hasReturnField());
    }

    @When("user selects a departure date {string}")
    public void user_selects_a_departure_date(String departureDate) {
        marsAirMainPage.setDepartureDate(departureDate);
    }

    @When("user selects a return date {string}")
    public void user_selects_a_return_date(String returnDate) {
        marsAirMainPage.setReturnDate(returnDate);
    }

    @When("click on search button")
    public void click_on_search_button() {
        marsAirMainPage.clickSearchBtn();
    }

    @Then("a success message for available seats should be displayed")
    public void a_success_message_for_available_seats_should_be_displayed() {
        String actualMsg = searchResultsPage.getSearchResultsMsg();

        Assert.assertEquals("Wrong Message!", Constants.SUCCESS_MSG, actualMsg);
    }

    @Then("a message for no available seats should be displayed")
    public void a_message_for_no_available_seats_should_be_displayed() {
        String actualMsg = searchResultsPage.getSearchResultsMsg();

        Assert.assertEquals("Wrong Message!", Constants.NO_SEATS_MSG, actualMsg);
    }
}
