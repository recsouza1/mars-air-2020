package util;

import manager.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
    }

    public void setElementValue(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void clickWithJavaScript(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public String getElementText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element.getText().trim();
    }

    public String getCurrentlyUrl() {
        return driver.getCurrentUrl();
    }

    public boolean hasElement(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isFieldName(By locator, String fieldName) {
        if (getElementText(locator).equals(fieldName)) {
            return true;
        }
        return false;
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
