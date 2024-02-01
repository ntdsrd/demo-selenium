package actions;

import actions.commons.BasePage;
import interfaces.PhongBanUI;
import org.openqa.selenium.WebDriver;

public class PhongBan extends BasePage {
    WebDriver driver;

    public PhongBan(WebDriver driver) {
        this.driver = driver;
    }

    public void diChuyenDenManHinhPhongBan() {
        clickToElement(driver, PhongBanUI.PHONG_BAN_HEADER);
    }

    public boolean verifyPhongBanPageDisplay() {
        return isDisplayElement(driver, PhongBanUI.BUTTON_THEM_MOI_PHONG_BAN);
    }
}