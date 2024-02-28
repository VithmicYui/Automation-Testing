package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.home.PageFreshVegetables;
import page.home.category.PageBeverages;
import page.home.category.PageCategory;
import page.home.category.PageCoffee;
import page.home.category.PageFastFood;
import page.home.profile.PageProfile;

public class ECartSteps extends BaseECartSteps {
    PageCategory pageCategory = new PageCategory(mobile);
    PageFreshVegetables pageFreshVegetables = new PageFreshVegetables(mobile);
    PageCoffee pageCoffee = new PageCoffee(mobile);
    PageFastFood pageFastFood = new PageFastFood(mobile);
    PageBeverages pageBeverages = new PageBeverages(mobile);
    PageProfile pageProfile = new PageProfile(mobile);

    String nameProduct = "";
    String priceProduct = "";
    String quantity = "";
    String location = "";

    @Given("Open eCart App")
    public void openECartApp() {
        log.info("Log: openECartApp");
        pageCategory.startECardApp();
    }

    @Then("the welcome screen should display")
    public void theWelcomeScreenShouldDisplay() {
        log.info("Log: theWelcomeScreenShouldDisplay");
        pageCategory.verifyShowScreenWelcome();
    }

    @And("Navigate to {string} screen")
    public void navigateToScreen(String arg0) {
        log.info("Log: navigateToScreen");
        pageCategory.navigateToGetStarted();
    }

    @Then("The Default Delivery Location screen display")
    public void theDefaultDeliveryLocationScreenDisplay() {
        log.info("Log: theDefaultDeliveryLocationScreenDisplay");
        pageCategory.verifyShowScreenLocation();
    }

    @And("Select {string} location")
    public void selectLocation(String arg0) throws InterruptedException {
//        pageCategory.verifyShowScreenLocation();
        log.info("Log: selectLocation");
        pageCategory.clickToLocationAll();
        pageCategory.verifyShowScreenHomeECard();
    }

    @And("Click to Category menu item")
    public void clickToCategoryMenuItem() {
        log.info("Log: clickToCategoryMenuItem");
        pageCategory.clickToCategory();
    }

    @Then("The Category screen display {int} categories")
    public void theCategoryScreenDisplayCategories(int arg0) {
        log.info("Log: theCategoryScreenDisplayCategories");
        pageCategory.verifyShowScreenCategory();
    }

    @And("Scroll to Fresh Vegetables")
    public void scrollToFreshVegetables() throws InterruptedException {
        log.info("Log: scrollToFreshVegetables");
        pageFreshVegetables.scrollToFreshVegetables();
    }
//
//    @And("Click to View All")
//    public void clickToViewAll() {
//        log.info("");
//        pageFreshVegetables.clickToViewAll();
//    }

    @Then("the Fresh Vegetables category should be displayed with {int} products")
    public void theFreshVegetablesCategoryShouldBeDisplayedWithProducts(int arg0) {
        log.info("");
    }

    @And("the Fresh Vegetables screen should be displayed with {int} products")
    public void theFreshVegetablesScreenShouldBeDisplayedWithProducts(int arg0) throws InterruptedException {
        log.info("Log: theFreshVegetablesScreenShouldBeDisplayedWithProducts");
        pageFreshVegetables.verifyShowScreenVegetables();
    }

    @And("Scroll to Coffee")
    public void scrollToCoffee() throws InterruptedException {
        log.info("Log: scrollToCoffee");
        pageCoffee.scrollToCoffee();
    }

    @And("Click to {string}")
    public void clickTo(String arg0) throws InterruptedException {
        log.info("Log: clickToCoffeeProduct");
        pageCoffee.scrollToCoffeeProduct();
        nameProduct = mobile.getText(pageCoffee.TXT_NAME_PRODUCT_CHOSE);
        priceProduct = mobile.getText(pageCoffee.TXT_PRICE_PRODUCT_CHOSE);
        pageCoffee.clickToCoffeeProduct();
    }

    @Then("the product detail screen should be displayed")
    public void theProductDetailScreenShouldBeDisplayed() throws InterruptedException {
        log.info("Log: theProductDetailScreenShouldBeDisplayed");
        pageCoffee.verifyShowScreenDetailProduct(nameProduct, priceProduct);
    }

    @And("Click to Fast Food")
    public void clickToFastFood() {
        log.info("Log: clickToFastFood");
        pageCategory.clickToFastFood();
    }

    @And("Click {string} with Quantity = {int} of {string} product")
    public void clickWithQuantityOfProduct(String arg0, int arg1, String arg2) throws InterruptedException {
        log.info("Log: clickWithQuantityOfProduct");
        pageFastFood.clickAddToCartFastFood();
        log.info("Log: clickAddToCart " + arg2);
        nameProduct = mobile.getText(pageFastFood.TXT_NAME_PRODUCT_CHOSE);
        priceProduct = mobile.getText(pageFastFood.TXT_PRICE_PRODUCT_CHOSE);
        pageFastFood.manipulateQuantity(2);
        quantity = mobile.getText(pageFastFood.TXT_QUANTITY);
    }

    @And("Click to Cart icon on top screen")
    public void clickToCartIconOnTopScreen() {
        log.info("Log: clickToCartIconOnTopScreen");
        pageFastFood.clickToCartOnTopScreen();
    }

    @And("Select {int} location")
    public void selectLocation(int arg0) {
        log.info("Log: selectLocation");
        location = mobile.getText(pageFastFood.BTN_LOCATION_370405);
        pageFastFood.clickLocation370405();
    }

    @Then("the Cart should be displayed")
    public void theCartShouldBeDisplayed() {
        log.info("Log: theCartShouldBeDisplayed");
        pageFastFood.checkLocation370405(location);
        pageFastFood.checkQuantity(quantity);
        pageFastFood.verifyShowScreenCart(nameProduct, priceProduct);
    }

    @And("Click to Beverages")
    public void clickToBeverages() {
        log.info("Log: clickToBeverages");
        pageCategory.clickToBeverages();
    }

    @And("Click to CONTINUE button")
    public void clickToCONTINUEButton() {
        log.info("Log: clickToContinue");
        pageBeverages.clickToContinue();
    }

    @Then("the Payment screen should be displayed")
    public void thePaymentScreenShouldBeDisplayed() {
        log.info("Log: thePaymentScreenShouldBeDisplayed");
        pageBeverages.verifyShowScreenPayment(location, nameProduct);
//        pageBeverages.verifyShowScreenPayment();
    }

    @And("Click to Profile on footer menu")
    public void clickToProfileOnFooterMenu() {
        log.info("Log: clickToProfileOnFooterMenu");
        pageCategory.clickToProfile();
    }

    @And("Click to Welcome Guest")
    public void clickToWelcomeGuest() {
        log.info("Log: clickToWelcomeGuest");
        pageProfile.clickToWelcomeGuest();
    }

//    @And("Click to login button")
//    public void clickToLoginButton() {
//    }


    @And("Click again to Profile on footer menu")
    public void clickAgainToProfileOnFooterMenu() {
        log.info("Log: click to profile");
        pageCategory.clickToProfile();
    }

    @Then("the Profile screen should be displayed with the user's information and options to manage the profile")
    public void theProfileScreenShouldBeDisplayedWithTheUserSInformationAndOptionsToManageTheProfile() throws InterruptedException {
        log.info("Log: theProfileScreenShouldBeDisplayedWithTheUserSInformationAndOptionsToManageTheProfile");
        pageProfile.verifyShowScreenPageProfile();
    }

    @And("Click to View All Fresh Vegetables")
    public void clickToViewAllFreshVegetables() {
        log.info("Log: clickToViewAllFreshVegetables");
        pageFreshVegetables.clickToViewAllFreshVegetables();
    }

    @And("Click to View All Coffee")
    public void clickToViewAllCoffee() {
        log.info("Log: clickToViewAllCoffee");
        pageCoffee.clickToViewAllCoffee();
    }

    @And("Click to Login button")
    public void clickToLoginButton() {
        log.info("Log: clickToLoginButton");
        pageBeverages.clickToLogin();
    }

    @And("Click {string} with Quantity = {int} of {string} product of Beverages")
    public void clickWithQuantityOfProductOfBeverages(String arg0, int arg1, String arg2) throws InterruptedException {
        log.info("clickWithQuantityOfProduct");
        pageBeverages.clickAddToCartBeverages();
        log.info("clickAddToCart " + arg2);
        nameProduct = mobile.getText(pageBeverages.TXT_NAME_PRODUCT_CHOSE);
        priceProduct = mobile.getText(pageBeverages.TXT_PRICE_PRODUCT_CHOSE);
        pageBeverages.manipulateQuantity(2);
        quantity = mobile.getText(pageBeverages.TXT_QUANTITY);
    }

    @And("Select {int} location of Payment")
    public void selectLocationOfPayment(int arg0) {
        log.info("Log: selectLocationOfPayment");
        location = mobile.getText(pageBeverages.BTN_LOCATION_370001);
        pageBeverages.clickLocation370001();
    }
}
