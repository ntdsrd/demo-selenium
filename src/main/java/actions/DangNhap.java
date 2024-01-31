package actions;

import actions.commons.BasePage;
import interfaces.DangNhapUI;
import org.openqa.selenium.WebDriver;

public class DangNhap extends BasePage {
    WebDriver driver;

    public void nhapTenGianHang(String tenGianHang) {
        sendKeyToElement(driver, DangNhapUI.TEN_GIAN_HANG, tenGianHang);
    }

    public void nhapTenDangNhap(String tenDangNhap) {
        sendKeyToElement(driver, DangNhapUI.TEN_DANG_NHAP, tenDangNhap);
    }

    public void nhapMatKhau(String matKhau) {
        sendKeyToElement(driver, DangNhapUI.MAT_KHAU, matKhau);
    }

    public void clickButtonQuanLi() {
        clickToElement(driver, DangNhapUI.BUTTON_QUAN_LY);
    }
}