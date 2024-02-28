package page;

import core.KeywordAndroid;
import core.LogHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;

public class BasePageECart {
    public static Logger log = LogHelper.getLogger();
    public By BTN_SKIP = By.xpath("//android.widget.TextView[@text=\"SKIP\"]");
    public By BTN_NEXT = By.xpath("//android.widget.TextView[@text=\"NEXT\"]");
    public By TXT_WELCOME = By.xpath("//android.widget.TextView[@text=\"Look for things around you\"]");
    public By BTN_GET_STARTED = By.xpath("//android.widget.TextView[@text=\"GET STARTED\"]");
    public By FRM_HOME = By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]");
    public By FRM_CATEGORY = By.xpath("//android.widget.FrameLayout[@content-desc=\"Category\"]");
    public By FRM_PROFILE = By.xpath("//android.widget.FrameLayout[@content-desc=\"Profile\"]");
    public By BTN_FRESH_VEGETABLES = By.xpath("//android.widget.TextView[@text=\"Fresh Vagetables\"]");
    public By BTN_COFFEE = By.xpath("//android.widget.TextView[@text=\"Coffee\"]");
    public By BTN_VIEW_ALL = By.xpath("(//android.widget.TextView[@text=\"View All\"])[1]");
    public By BTN_LOCATION_ALL = By.xpath("//android.widget.TextView[@text=\"All\"]");
    public By TXT_DEFAULT_LOCATION = By.xpath("//android.widget.TextView[@text=\"Default Delivery Location\"]");
    public By TXT_SEARCH_PIN = By.xpath("//android.widget.EditText[@text=\"Search Pin Code\"]");
    public By BTN_SEARCH_PIN = By.xpath("//android.widget.TextView[@text=\"Search\"]");
    protected KeywordAndroid mobile;

    public BasePageECart(KeywordAndroid mobile) {
        this.mobile = mobile;
    }

    public void startECardApp() {
        log.info("Log: Open Tiki App");
        mobile.startApplication("http://127.0.0.1:4723/", "platformName=android", "platformVersion=11", "udid=192.168.53.102:5555"
                , "appPackage=wrteam.multivendor.customer", "appActivity=wrteam.multivendor.customer.activity.WelcomeActivity");
    }

    public void verifyShowScreenWelcome() {
        log.info("verifyShowScreenWelcome");
        mobile.waitElementVisible(BTN_SKIP, 30);
        mobile.waitElementVisible(BTN_NEXT, 30);
        mobile.waitElementVisible(TXT_WELCOME, 30);
    }

    public void navigateToGetStarted() {
        log.info("navigateToGetStarted");
        verifyShowScreenWelcome();
        mobile.tap(BTN_NEXT);
        mobile.tap(BTN_NEXT);
        mobile.tap(BTN_GET_STARTED);
    }

    public void clickToLocationAll() throws InterruptedException {
        log.info("clickToLocationAll");
        Thread.sleep(1000);
        mobile.tap(BTN_LOCATION_ALL);
    }

    public void clickToCategory() {
        log.info("clickToCategory");
        mobile.tap(FRM_CATEGORY);
//        clickToLocationAll();
//        mobile.tap(FRM_CATEGORY);
    }

    public void verifyShowScreenHomeECard() {
        log.info("verifyShowScreenHomeECard");
        mobile.waitElementVisible(FRM_HOME, 30);
        mobile.waitElementVisible(FRM_CATEGORY, 30);
        mobile.waitElementVisible(FRM_PROFILE, 30);
    }

    public void scrollToFreshVegetables() throws InterruptedException {
        log.info("scrollToFreshVegetables");
        mobile.scrollDownToElement(BTN_FRESH_VEGETABLES);
    }

    public void scrollToCoffee() throws InterruptedException {
        log.info("scrollToCoffee");
        mobile.scrollDownToElement(BTN_COFFEE);
    }

    public void clickToProfile() {
        log.info("clickToProfile");
        mobile.tap(FRM_PROFILE);
    }

    public void verifyShowScreenLocation() {
        log.info("verifyShowScreenLocation");
        mobile.waitElementVisible(TXT_DEFAULT_LOCATION, 30);
        mobile.waitElementVisible(TXT_SEARCH_PIN, 30);
        mobile.waitElementVisible(BTN_SEARCH_PIN, 30);
    }
}
