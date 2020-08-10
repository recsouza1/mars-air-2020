package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;
import util.Constants;

public class MarsAirMainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By departureField = By.cssSelector("[for='departing']");
    private By departureSelect = By.cssSelector("#departing");
    private By returnField = By.cssSelector("[for='returning']");
    private By returnSelect = By.cssSelector("#returning");
    private By promoCode = By.cssSelector("#promotional_code");
    private By searchBtn = By.cssSelector("[type='submit']");
    private By marsAirLogo = By.xpath("//a[contains(text(),' MarsAir')]");
    private By pageFormTitle = By.xpath("//h2[contains(text(),'Welcome to MarsAir!')]");

    private String departureFieldName = "Departure";
    private String returnFieldName = "Return";


    public MarsAirMainPage(WebDriver driver) {
        this.driver = driver;
        commonActions = new CommonActions(driver);
        wait = DriverFactory.getWait();
    }

    public MarsAirMainPage accessMainPage() {
        driver.get(Constants.MAIN_URL);
        return this;
    }

    public void setDepartureDate(String value) {
        Select departureDate = new Select(commonActions.findElement(departureSelect));
        departureDate.selectByVisibleText(value);
    }

    public void setReturnDate(String value) {
        Select returnDate = new Select(commonActions.findElement(returnSelect));
        returnDate.selectByVisibleText(value);
    }

    public void setPromoCode(String code) {
        commonActions.setElementValue(promoCode, code);
    }

    public void clickSearchBtn() {
        commonActions.click(searchBtn);
    }

    public void clickMarsAirLogo() {
        commonActions.clickWithJavaScript(marsAirLogo);
    }

    public boolean hasDepartureField() {
        if (commonActions.isFieldName(departureField, departureFieldName) && commonActions.hasElement(departureSelect)) {
            return true;
        }
        return false;
    }

    public boolean hasReturnField() {
        if (commonActions.isFieldName(returnField, returnFieldName) && commonActions.hasElement(returnSelect)) {
            return true;
        }
        return false;
    }

    public String getPageFormTitle() {
        return commonActions.getElementText(pageFormTitle);
    }

    public String getUrlTitle() {
        return driver.getTitle();
    }



}
