import actions.DangNhap;
import actions.TongQuan;
import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DangNhapTestCase extends BaseTest {
    DangNhap dangNhap;
    TongQuan tongQuan;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        dangNhap = new PageGeneratorManager().getDangNhapPage(driver);
    }

    @Test(description = "Trường hợp đăng nhập thành công")
    public void DangNhap01() {
        //step 1: nhập tên gian hàng
        dangNhap.nhapTenGianHang(GlobalConstants.TEN_GIAN_HANG);
        //step 2: nhập tên đăng nhập
        dangNhap.nhapTenDangNhap(GlobalConstants.TEN_DANG_NHAP);
        //step 3: nhập mật khẩu
        dangNhap.nhapMatKhau(GlobalConstants.MAT_KHAU);
        //step 4: click button quản lý
        dangNhap.clickButtonQuanLy();
        //step 5: kiểm tra hiển thị màn hình tổng quan
        tongQuan = new PageGeneratorManager().getTongQuanPage(driver);
        tongQuan.kiemTraHienThiManHinhTongQuan();
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }
}