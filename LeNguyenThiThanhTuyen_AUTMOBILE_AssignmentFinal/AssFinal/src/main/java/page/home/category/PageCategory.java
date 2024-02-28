package page.home.category;

import core.KeywordAndroid;
import core.LogHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import page.BasePageECart;

public class PageCategory extends BasePageECart {
    public static Logger log = LogHelper.getLogger();
    public By BTN_COFFEE_PRODUCT = By.xpath("//android.widget.TextView[@text=\"Coffee Product\"]");
    public By BTN_FAST_FOOD = By.xpath("//android.widget.TextView[@text=\" Fast Food\"]");
    public By BTN_HOME_SUPPLIES = By.xpath("//android.widget.TextView[@text=\" Home Supplies, Utilities & Stationery\"]");
    public By BTN_BEVERAGES = By.xpath("//android.widget.TextView[@text=\"Beverages\"]");
    public By BTN_BABY = By.xpath("//android.widget.TextView[@text=\" Baby Need's\"]");
    public By BTN_VEGETABLE = By.xpath("//android.widget.TextView[@text=\"Vegetables\"]");

    public PageCategory(KeywordAndroid mobile) {
        super(mobile);
    }

    public void verifyShowScreenCategory() {
        log.info("verifyShowScreenCategory");
        mobile.waitElementVisible(BTN_COFFEE_PRODUCT, 30);
        mobile.waitElementVisible(BTN_FAST_FOOD, 30);
        mobile.waitElementVisible(BTN_HOME_SUPPLIES, 30);
        mobile.waitElementVisible(BTN_BEVERAGES, 30);
        mobile.waitElementVisible(BTN_BABY, 30);
        mobile.waitElementVisible(BTN_VEGETABLE, 30);
    }

    public void clickToFastFood() {
        log.info("clickToFastFood");
        mobile.tap(BTN_FAST_FOOD);
    }

    public void clickToBeverages() {
        log.info("clickToBeverages");
        mobile.tap(BTN_BEVERAGES);
    }
}
