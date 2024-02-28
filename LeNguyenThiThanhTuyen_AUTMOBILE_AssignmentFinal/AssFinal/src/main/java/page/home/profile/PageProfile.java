package page.home.profile;

import core.KeywordAndroid;
import org.openqa.selenium.By;
import page.BasePageECart;

public class PageProfile extends BasePageECart {
    public By BTN_WELCOME_GUEST = By.xpath("//android.widget.TextView[@text=\"Welcome Guest\"]");
    public By TXT_HOME = By.xpath("//android.widget.TextView[@text=\"Home\"]");
    public By TXT_CART = By.xpath("//android.widget.TextView[@text=\"Cart\"]");
    public By TXT_NOTIFICATIONS = By.xpath("//android.widget.TextView[@text=\"Notifications\"]");
    public By TXT_YOUR_ORDERS = By.xpath("//android.widget.TextView[@text=\"Your Orders\"]");
    public By TXT_WALLET_HISTORY = By.xpath("//android.widget.TextView[@text=\"Wallet History\"]");
    public By TXT_TRANSACTION_HISTORY = By.xpath("//android.widget.TextView[@text=\"Transaction History\"]");
    public By TXT_CHANGE_PASSWORD = By.xpath("//android.widget.TextView[@text=\"Change Password ?\"]");
    public By TXT_MANAGE_ADDRESS = By.xpath("//android.widget.TextView[@text=\"Manage Addresses\"]");
    public By TXT_REFER_EARN = By.xpath("//android.widget.TextView[@text=\"Refer & Earn\"]");
    public By TXT_CONTACT_US = By.xpath("//android.widget.TextView[@text=\"Contact Us\"]");
    public By TXT_ABOUT_US = By.xpath("//android.widget.TextView[@text=\"About Us\"]");
    public By TXT_RATE_US = By.xpath("//android.widget.TextView[@text=\"Rate Us\"]");
    public By TXT_SHARE_APP = By.xpath("//android.widget.TextView[@text=\"Share App\"]");
    public By TXT_FAQ = By.xpath("//android.widget.TextView[@text=\"FAQ\"]");
    public By TXT_TERM_CONDITIONS = By.xpath("//android.widget.TextView[@text=\"Terms & Conditions\"]");
    public By TXT_PRIVACY_POLICY = By.xpath("//android.widget.TextView[@text=\"Privacy Policy\"]");
    public By TXT_LOGOUT = By.xpath("//android.widget.TextView[@text=\"Logout\"]");

    public PageProfile(KeywordAndroid mobile) {
        super(mobile);
    }

    public void clickToWelcomeGuest() {
        log.info("clickToWelcomeGuest");
        mobile.waitElementVisible(BTN_WELCOME_GUEST, 30);
        mobile.tap(BTN_WELCOME_GUEST);
    }

    public void verifyShowScreenPageProfile() throws InterruptedException {
        log.info("verifyShowScreenPageProfile");
        mobile.scrollDownToElement(TXT_HOME);
        mobile.scrollDownToElement(TXT_CART);
        mobile.scrollDownToElement(TXT_NOTIFICATIONS);
        mobile.scrollDownToElement(TXT_YOUR_ORDERS);
        mobile.scrollDownToElement(TXT_WALLET_HISTORY);
        mobile.scrollDownToElement(TXT_TRANSACTION_HISTORY);
        mobile.scrollDownToElement(TXT_CHANGE_PASSWORD);
        mobile.scrollDownToElement(TXT_MANAGE_ADDRESS);
        mobile.scrollDownToElement(TXT_REFER_EARN);
        mobile.scrollDownToElement(TXT_CONTACT_US);
        mobile.scrollDownToElement(TXT_ABOUT_US);
        mobile.scrollDownToElement(TXT_RATE_US);
        mobile.scrollDownToElement(TXT_SHARE_APP);
        mobile.scrollDownToElement(TXT_FAQ);
        mobile.scrollDownToElement(TXT_TERM_CONDITIONS);
        mobile.scrollDownToElement(TXT_PRIVACY_POLICY);
        mobile.scrollDownToElement(TXT_LOGOUT);
    }
}
