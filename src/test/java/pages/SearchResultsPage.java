package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonActions commonActions;

    private By searchResultsFormTitle = By.xpath("//h2[contains(text(),'Search Results')]");
    private By backBtn = By.xpath("//a[contains(text(),'Back')]");
    private By searchResultsMsg = By.cssSelector("#content p:nth-child(2)");
    private By promoCodeMsg = By.cssSelector(".promo_code");
    private By marsAirLogo = By.xpath("//a[contains(text(),' MarsAir')]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        commonActions = new CommonActions(driver);
        wait = DriverFactory.getWait();
    }

    public void clickBackBtn() {
        commonActions.click(backBtn);
    }

    public String getSearchResultsMsg() {
        return commonActions.getElementText(searchResultsMsg);
    }

    public String getPromoCodeMsg() {
        return commonActions.getElementText(promoCodeMsg);
    }

    public void clickMarsAirLogo() {
        commonActions.clickWithJavaScript(marsAirLogo);
    }
}
