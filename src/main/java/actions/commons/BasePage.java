package actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriverWait explicitWait;
    Actions actions;

    public By getXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getXpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getXpath(locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
    }

    public void waitForAllElementsVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(locator)));
    }

    public String getElementText(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getText().trim();
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        getElement(driver, locator).click();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        actions = new Actions(driver);
        waitForElementVisible(driver, locator);
        actions.moveToElement(getElement(driver, locator)).perform();
    }
}