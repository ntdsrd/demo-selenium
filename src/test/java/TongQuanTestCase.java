import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TongQuanTestCase extends BaseTest {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        PageGeneratorManager.getDangNhapPage(driver).loginSuccessfully();
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