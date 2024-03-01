package actions;

import actions.commons.BasePage;
import interfaces.DangNhapUI;
import org.openqa.selenium.WebDriver;

public class DangNhap extends BasePage {
    WebDriver driver;

    public DangNhap(WebDriver driver) {
        this.driver = driver;
    }

    public void nhapTenGianHang(String tenGianHang) {
        sendKeyToElement(driver, DangNhapUI.TEN_GIAN_HANG, tenGianHang);
        sleepInSecond(1);
    }

    public void nhapTenDangNhap(String tenDangNhap) {
        sendKeyToElement(driver, DangNhapUI.TEN_DANG_NHAP, tenDangNhap);
        sleepInSecond(1);
    }

    public void nhapMatKhau(String matKhau) {
        sendKeyToElement(driver, DangNhapUI.MAT_KHAU, matKhau);
        sleepInSecond(1);
    }

    public void clickButtonQuanLy() {
        clickToElement(driver, DangNhapUI.BUTTON_QUAN_LY);
    }

    public void loginSuccessfully(String tenGianHang, String tenDangNhap, String matKhau) {
        nhapTenGianHang(tenGianHang);
        nhapTenDangNhap(tenDangNhap);
        nhapMatKhau(matKhau);
        clickButtonQuanLy();
    }
}