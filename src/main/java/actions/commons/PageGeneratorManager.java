package actions.commons;

import actions.DangNhap;
import actions.PhongBan;
import actions.TongQuan;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static DangNhap getDangNhapPage(WebDriver driver) {
        return new DangNhap(driver);
    }

    public static TongQuan getTongQuanPage(WebDriver driver) {
        return new TongQuan(driver);
    }

    public static PhongBan getPhongBanPage(WebDriver driver) {
        return new PhongBan(driver);
    }
}