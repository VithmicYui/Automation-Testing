package page.home.category;

import core.KeywordAndroid;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import page.BasePageECart;

public class PageFastFood extends BasePageECart {
    public By TXT_NAME_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@text=\"Kurkure Namkeen - Masala Munch,\"]");
    public By TXT_PRICE_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@text=\"$13.00\"]");
    public By BTN_ADD_TO_CART = By.xpath("(//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnAddToCart\"])[6]");
    public By BTN_ADD_QUANTITY = By.xpath("(//android.widget.ImageButton[@content-desc=\"eCart Multi Vendor - Customer\"])[12]");
    public By TXT_QUANTITY = By.xpath("(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvQuantity\"])[6]");
    public By BTN_CART = By.xpath("//android.widget.Button[@content-desc=\"Cart\"]");
    public By TXT_SIMILAR_NAME = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]");
    public By TXT_SIMILAR_PRICE = By.xpath("(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPrice\"])[7]");
    public By TXT_PRODUCT_MEASUREMENT = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvMeasurement\" and @text=\"85 kg\"]");
    public By TXT_PRODUCT_TOTAL_PRICE = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTotalPrice\"]");
    public By TXT_PRODUCT_QUANTITY = By.xpath("(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvQuantity\"])[7]");
    public By BTN_DELETE = By.xpath("//android.widget.TextView[@text=\"Delete\"]");
    public By BTN_SAVE_FOR_LATER = By.xpath("//android.widget.TextView[@text=\"Save for later\"]");
    public By BTN_USE_PROMO_CODE = By.xpath("//android.widget.TextView[@text=\"Use Promo Code\"]");
    public By BTN_CONTINUTE = By.xpath("//android.widget.TextView[@text=\"CONTINUE\"]");
    public By BTN_LOCATION_370405 = By.xpath("//android.widget.TextView[@text=\"370405\"]");

    public PageFastFood(KeywordAndroid mobile) {
        super(mobile);
    }

    public void clickAddToCartFastFood() throws InterruptedException {
        log.info("clickAddToCartFastFood");
        mobile.scrollDownToElement(TXT_NAME_PRODUCT_CHOSE);
        log.info("da tim thay name");
        mobile.scrollDownToElement(TXT_PRICE_PRODUCT_CHOSE);
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

    public void clickLocation370405() {
        log.info("clickLocation370405");
        mobile.tap(BTN_LOCATION_370405);
    }

    public void checkLocation370405(String location) {
        log.info("checkLocation370405");
        String location370405 = mobile.getText(BTN_LOCATION_370405);
        Assert.assertEquals(location, location370405, "Location does not match. Expected: " + location + ", Actual: " + location370405);
        log.info("Location is a match: " + location);
    }

    public void checkQuantity(String quantity) {
        log.info("checkQuantity");
        String actualQuantity = mobile.getText(TXT_PRODUCT_QUANTITY);
        Assert.assertEquals(quantity, actualQuantity, "Quantity does not match. Expected: " + quantity + ", Actual: " + actualQuantity);
        log.info("Quantity is a match: " + quantity);
    }

    public void verifyShowScreenCart(String expectedName, String expectedPrice) {
        log.info("verifyShowScreenCart");
        mobile.waitElementVisible(TXT_SIMILAR_NAME, 30);
        mobile.waitElementVisible(TXT_SIMILAR_PRICE, 30);

        String actualName = mobile.getText(TXT_SIMILAR_NAME);
        String actualPrice = mobile.getText(TXT_SIMILAR_PRICE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualName, expectedName.trim(), "Tên sản phẩm không khớp.");
        softAssert.assertEquals(actualPrice, expectedPrice, "Giá sản phẩm không khớp.");
        softAssert.assertAll();

        mobile.waitElementVisible(TXT_PRODUCT_MEASUREMENT, 30);
        mobile.waitElementVisible(TXT_PRODUCT_TOTAL_PRICE, 30);
        mobile.waitElementVisible(BTN_DELETE, 30);
        mobile.waitElementVisible(BTN_SAVE_FOR_LATER, 30);
        mobile.waitElementVisible(BTN_USE_PROMO_CODE, 30);
        mobile.waitElementVisible(BTN_CONTINUTE, 30);
    }

}
