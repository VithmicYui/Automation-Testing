package page.home.category;

import core.KeywordAndroid;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import page.BasePageECart;

public class PageBeverages extends BasePageECart {
    public By TXT_NAME_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@text=\"Sunfeast Dark Fantasy Choco Fills, 600g\"]");
    public By TXT_PRICE_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPrice\" and @text=\"$207.10\"]");
    public By BTN_ADD_TO_CART = By.xpath("(//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnAddToCart\"])[5]");
    public By BTN_ADD_QUANTITY = By.xpath("(//android.widget.ImageButton[@content-desc=\"eCart Multi Vendor - Customer\"])[10]");
    public By TXT_QUANTITY = By.xpath("(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvQuantity\"])[5]");
    public By BTN_CART = By.xpath("//android.widget.Button[@content-desc=\"Cart\"]");
    public By BTN_LOCATION_370001 = By.xpath("//android.widget.TextView[@text=\"370001\"]");
    public By TXT_SIMILAR_NAME = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvItemName\"]");
    public By TXT_TOTAL_PRICE = By.xpath("(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSubTotal\"])[1]");
    public By TXT_SUBTOTAL = By.xpath("//android.widget.TextView[@text=\"Subtotal\"]");
    public By TXT_DELIVERY_CHARGE = By.xpath("//android.widget.TextView[@text=\"Delivery Charge\"]");
    public By TXT_YOU_SAVED = By.xpath("//android.widget.TextView[@text=\"You saved \"]");
    public By TXT_GRAND_TOTAL = By.xpath("//android.widget.TextView[@text=\"Grand Total\"]");
    public By BTN_CONTINUE = By.xpath("//android.widget.TextView[@text=\"CONTINUE\"]");
    public By BTN_LOGIN = By.xpath("//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnLogin\"]");
    public By TXT_SHIPPING_DETAIL = By.xpath("//android.widget.TextView[@text=\"Shipping Detail\"]");
    public By TXT_PIN_CODE = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvAddress\"]");
    public By ILM_NEXT_1_DAY = By.xpath("(//android.widget.FrameLayout[@resource-id=\"wrteam.multivendor.customer:id/relativeLyt\"])[1]/android.widget.RelativeLayout");
    public By TXT_ORDER_SUMMARY = By.xpath("//android.widget.TextView[@text=\"Order Summary\"]");

    public PageBeverages(KeywordAndroid mobile) {
        super(mobile);
    }

    public void clickAddToCartBeverages() throws InterruptedException {
        log.info("clickAddToCartBeverages");
        mobile.scrollLeftMenuToElement(TXT_NAME_PRODUCT_CHOSE);
        log.info("da tim thay name");
        mobile.scrollLeftMenuToElement(TXT_PRICE_PRODUCT_CHOSE);
        log.info("da tim thay price");
        mobile.tap(BTN_ADD_TO_CART);
        log.info("da nhan add to cart");
    }

    public void manipulateQuantity(int value) {
        String quantityText = mobile.getText(TXT_QUANTITY);
        int quantityValue = Integer.parseInt(quantityText);
        while (quantityValue < value) {
            mobile.tap(BTN_ADD_QUANTITY);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            quantityText = mobile.getText(TXT_QUANTITY);
            quantityValue = Integer.parseInt(quantityText);
        }
    }

    public void clickToCartOnTopScreen() {
        log.info("click to cart on top screen");
        mobile.tap(BTN_CART);
    }

    public void clickLocation370001() {
        log.info("clickLocation370001");
        mobile.tap(BTN_LOCATION_370001);
    }

    public void checkLocation370001(String location) {
        log.info("checkLocation370001");
        String location370001 = mobile.getText(TXT_PIN_CODE);
        Assert.assertTrue(location370001.contains(location), "Location does not match the expected pattern. Expected: " + location + ", Actual: " + location370001);
        log.info("Location is a match: " + location);
    }

    public void clickToContinue() {
        log.info("clickToContinue");
        mobile.tap(BTN_CONTINUE);
    }

    public void clickToLogin() {
        log.info("clickToLogin");
        mobile.tap(BTN_LOGIN);
    }

    public void verifyShowScreenPayment(String location, String name) {
        log.info("verifyShowScreenPayment");
        mobile.waitElementVisible(TXT_SHIPPING_DETAIL, 30);
        log.info("SHIPPING_DETAIL");
        checkLocation370001(location);
        mobile.tap(ILM_NEXT_1_DAY);
        log.info("NEXT_1_DAY");
        mobile.waitElementVisible(TXT_ORDER_SUMMARY, 30);
        log.info("ORDER_SUMMARY");
        verifyNameProduct(name);
        log.info(" verifyNameProduct");
        mobile.waitElementVisible(TXT_SUBTOTAL, 30);
        log.info("SUBTOTAL");
        mobile.waitElementVisible(TXT_TOTAL_PRICE, 30);
        log.info("TOTAL_PRICE");
        mobile.waitElementVisible(TXT_DELIVERY_CHARGE, 30);
        log.info("DELIVERY_CHARGE");
        mobile.waitElementVisible(TXT_YOU_SAVED, 30);
        log.info("YOU_SAVED");
        mobile.waitElementVisible(TXT_GRAND_TOTAL, 30);
        log.info("GRAND_TOTAL");
    }

    public void verifyNameProduct(String expectedName) {
        log.info("verifyNameProduct");
        mobile.waitElementVisible(TXT_SIMILAR_NAME, 30);

        String actualName = mobile.getText(TXT_SIMILAR_NAME);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualName.contains(expectedName.trim()), "Tên sản phẩm không khớp.");
        softAssert.assertAll();

    }
}
