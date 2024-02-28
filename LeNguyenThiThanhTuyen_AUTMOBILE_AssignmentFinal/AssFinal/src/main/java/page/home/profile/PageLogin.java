package page.home.profile;

import core.KeywordAndroid;
import org.openqa.selenium.By;
import page.BasePageECart;

public class PageLogin extends BasePageECart {
    public By TXT_MOBILE = By.xpath("//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/edtLoginMobile\"]");
    public By TXT_PASSWORD = By.xpath("//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/imgLoginPassword\"]");
    public By TXT_FORGOT_PASSWORD = By.xpath("//android.widget.TextView[@text=\"Forgot password ?\"]");
    public By TXT_SHIPPING_DETAIL = By.xpath("//android.widget.TextView[@text=\"Shipping Detail\"]");
    public By TXT_SIGN_UP = By.xpath("//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/tvSignUp\"]");

    public PageLogin(KeywordAndroid mobile) {
        super(mobile);
    }

    public void verifyShowScreenPageLogin() {
        log.info("verifyShowScreenPageLogin");
        mobile.waitElementVisible(TXT_MOBILE, 30);
        mobile.waitElementVisible(TXT_PASSWORD, 30);
        mobile.waitElementVisible(TXT_FORGOT_PASSWORD, 30);
        mobile.waitElementVisible(TXT_SHIPPING_DETAIL, 30);
        mobile.waitElementVisible(TXT_SIGN_UP, 30);
    }

}
