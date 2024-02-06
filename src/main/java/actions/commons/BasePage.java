package actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriverWait explicitWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

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

    public void waitForElementClickable(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
    }

    public String getElementText(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getText().trim();
    }

    public boolean isDisplayElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).isDisplayed();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void hoverToElement(WebDriver driver, String locator) {
        actions = new Actions(driver);
        waitForElementVisible(driver, locator);
        actions.moveToElement(getElement(driver, locator)).perform();
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        hoverToElement(driver, locator);
        getElement(driver, locator).click();
    }

    public void sleepInSecond(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
                                           String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        @SuppressWarnings("unchecked")
        List<WebElement> allItems =
                (List<WebElement>) explicitWait.until(ExpectedConditions.presenceOfElementLocated(getXpath(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0],scrollIntoView(true)", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click", getElement(driver, locator));
    }

    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object) params);
    }

    public WebElement getDynamicElement(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return getElement(driver, locator);
    }
}