package page.home;

import core.KeywordAndroid;
import core.LogHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import page.BasePageECart;

public class PageFreshVegetables extends BasePageECart {
    public static Logger log = LogHelper.getLogger();
    public By PRODUCT_01 = By.xpath("//android.widget.TextView[@text=\"Fresh Coriander, 100g\"]");
    public By PRODUCT_02 = By.xpath("//android.widget.TextView[@text=\"Fresh Mango, Thothapuri, 1 kg\"]");
    public By PRODUCT_03 = By.xpath("//android.widget.TextView[@text=\"Fresh Drumstick, 250g\"]");
    public By PRODUCT_04 = By.xpath("//android.widget.TextView[@text=\"Fresh Capsicum - Green\"]");
    public By PRODUCT_05 = By.xpath("//android.widget.TextView[@text=\"Fresh Mint Leaves\"]");
    public By PRODUCT_06 = By.xpath("//android.widget.TextView[@text=\"Fresh Watermelon Striped, 1 Piece (3-5 kg)\"]");
    public By PRODUCT_07 = By.xpath("//android.widget.TextView[@text=\"Fresh Sapota\"]");
    public By PRODUCT_08 = By.xpath("//android.widget.TextView[@text=\"Fresh Tomato Hybrid\"]");
    public By PRODUCT_09 = By.xpath("//android.widget.TextView[@text=\"Fresh Spinach\"]");
    public By PRODUCT_10 = By.xpath("//android.widget.TextView[@text=\"Fresh Onion\"]");
    public By TXT_VIEW_ALL = By.xpath("(//android.widget.TextView[@text=\"View All\"])[1]");

    public PageFreshVegetables(KeywordAndroid mobile) {
        super(mobile);
    }

    public void clickToViewAllFreshVegetables() {
        log.info("clickToViewAllFreshVegetables");
        mobile.tap(TXT_VIEW_ALL);
    }

    public void verifyShowScreenVegetables() throws InterruptedException {
        log.info("verifyShowScreenVegetables");
        mobile.scrollDownToElement(PRODUCT_01);
        mobile.scrollDownToElement(PRODUCT_02);
        mobile.scrollDownToElement(PRODUCT_03);
        mobile.scrollDownToElement(PRODUCT_04);
        mobile.scrollDownToElement(PRODUCT_05);
        mobile.scrollDownToElement(PRODUCT_06);
        mobile.scrollDownToElement(PRODUCT_07);
        mobile.scrollDownToElement(PRODUCT_08);
        mobile.scrollDownToElement(PRODUCT_09);
        mobile.scrollDownToElement(PRODUCT_10);
    }
}
