package actions.commons;

import actions.DangNhap;
import actions.TongQuan;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    private DangNhap dangNhap;
    private TongQuan tongQuan;

    public DangNhap getDangNhapPage(WebDriver driver) {
        if (dangNhap == null) {
            dangNhap = new DangNhap(driver);
        }
        return dangNhap;
    }

    public TongQuan getTongQuanPage(WebDriver driver) {
        if (tongQuan == null) {
            tongQuan = new TongQuan(driver);
        }
        return tongQuan;
    }
}