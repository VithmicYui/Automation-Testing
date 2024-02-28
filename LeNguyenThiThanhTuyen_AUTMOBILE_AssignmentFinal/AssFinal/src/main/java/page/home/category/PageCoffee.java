package page.home.category;

import core.KeywordAndroid;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import page.BasePageECart;

public class PageCoffee extends BasePageECart {
    public By TXT_NAME_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@text=\"High Octane Instant Coffee Paste with Hazelnut and Coconut Flavors, 150G - Pack of 2 (Hazelnut and Coconut Beaten Coffee Paste)\"]");
    public By TXT_PRICE_PRODUCT_CHOSE = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPrice\" and @text=\"$718.31\"]");
    public By BTN_ADD_TO_CART = By.xpath("//android.widget.Button[@text=\"Add to Cart\"]");
    public By BTN_GO_TO_CART = By.xpath("//android.widget.Button[@text=\"Go to Cart\"]");
    public By TXT_DETAIL_NAME = By.xpath("//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]");
    public By TXT_DETAIL_PRICE = By.xpath("//android.widget.TextView[@text=\"$718.31\"]");
    public By TXT_SIMILAR_PRODUCT = By.xpath("//android.widget.TextView[@text=\"Similar Products\"]");
    public By TXT_VIEW_ALL = By.xpath("(//android.widget.TextView[@text=\"View All\"])[2]");

    public PageCoffee(KeywordAndroid mobile) {
        super(mobile);
    }

    public void clickToViewAllCoffee() {
        log.info("clickToViewAllCoffee");
        mobile.tap(TXT_VIEW_ALL);
    }

    public void verifyShowScreenDetailProduct(String expectedName, String expectedPrice) throws InterruptedException {
        log.info("verifyShowScreenDetailProduct");
        mobile.waitElementVisible(TXT_DETAIL_NAME, 30);
        mobile.waitElementVisible(TXT_DETAIL_PRICE, 30);

        String actualName = mobile.getText(TXT_DETAIL_NAME);
        String actualPrice = mobile.getText(TXT_DETAIL_PRICE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualName, expectedName.trim(), "Tên sản phẩm không khớp.");
        softAssert.assertEquals(actualPrice, expectedPrice, "Giá sản phẩm không khớp.");
        softAssert.assertAll();

        mobile.scrollDownToElement(BTN_ADD_TO_CART);
        mobile.scrollDownToElement(BTN_GO_TO_CART);
        mobile.scrollDownToElement(TXT_SIMILAR_PRODUCT);
    }

    public void clickToCoffeeProduct() throws InterruptedException {
        log.info("clickToCoffeeProduct");
        mobile.tap(TXT_NAME_PRODUCT_CHOSE);
    }

    public void scrollToCoffeeProduct() throws InterruptedException {
        log.info("scrollToCoffeeProduct");
        mobile.scrollDownToElement(TXT_NAME_PRODUCT_CHOSE);
        mobile.scrollDownToElement(TXT_PRICE_PRODUCT_CHOSE);
    }

}
