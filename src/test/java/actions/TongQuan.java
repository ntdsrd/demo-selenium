package actions;

import actions.commons.BasePage;
import interfaces.TongQuanUI;
import org.openqa.selenium.WebDriver;

public class TongQuan extends BasePage {
    WebDriver driver;

    public TongQuan(WebDriver driver) {
        this.driver = driver;
    }

    public void kiemTraHienThiManHinhTongQuan() {
        waitForElementVisible(driver, TongQuanUI.TONG_QUAN_HEADER);
    }

    public boolean verifyLoginSuccessfully() {
        return isDisplayElement(driver, TongQuanUI.TONG_QUAN_HEADER);
    }
}