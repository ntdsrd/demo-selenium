import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PhongBanTestCase extends BaseTest {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        PageGeneratorManager.getDangNhapPage(driver).loginSuccessfully(GlobalConstants.TEN_GIAN_HANG,
                GlobalConstants.TEN_DANG_NHAP, GlobalConstants.MAT_KHAU);
    }

    @Test(description = "Di chuyển tới màn hình Phòng/Bàn")
    public void TongQuan01() {
        PageGeneratorManager.getPhongBanPage(driver).diChuyenDenManHinhPhongBan();
    }

    @AfterTest
    public void AfterTest() {
        driver.quit();
    }
}