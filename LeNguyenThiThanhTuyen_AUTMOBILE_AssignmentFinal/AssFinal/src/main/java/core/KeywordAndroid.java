package core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class KeywordAndroid {
    public static Logger log = LogHelper.getLogger();
    private static AndroidDriver androidDriver;

    public KeywordAndroid() {

    }

    /**
     * Android native app action keywords
     */

    public void startApplication(String... capabilities) {
        String appiumURL = "";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("noReset", true);
        for (String item : capabilities) {
            if (item.toUpperCase().contains("HTTP")) {
                appiumURL = item;
                log.info("appium URL = " + appiumURL);
            } else if (item.toUpperCase().contains("PLATFORMNAME")) {
                log.info("Platform name: " + item.substring(13));
                caps.setCapability("platformName", item.substring(13));
            } else if (item.toUpperCase().contains("PLATFORMVERSION")) {
                log.info("Platform version: " + item.substring(16));
                caps.setCapability("platformVersion", item.substring(16));
            } else if (item.toUpperCase().contains("UDID")) {
                log.info("UDID: " + item.substring(5));
                caps.setCapability("udid", item.substring(5));
            } else if (item.toUpperCase().contains("APPPACKAGE")) {
                log.info("App package: " + item.substring(11));
                caps.setCapability("appPackage", item.substring(11));
            } else if (item.toUpperCase().contains("APPACTIVITY")) {
                log.info("App activities: " + item.substring(12));
                caps.setCapability("appActivity", item.substring(12));
            } else if (item.toUpperCase().contains("APP")) {
                log.info("App: " + item.substring(4));
                caps.setCapability("app", item.substring(4));
            }
        }
        try {
            androidDriver = new AndroidDriver(new URL(appiumURL), caps);
            log.info("Successfully start an Appium session with: ");
            log.info(((RemoteWebDriver) androidDriver).getCapabilities().toString());
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
            log.error(e.getMessage());
        }
    }

    public void openBrowser(String appiumURL, String udid, String drivePath, String browser, String... url) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setUdid(udid)
                .setChromedriverExecutable(drivePath)
                .setAutomationName("UiAutomator2");
        options.setCapability(CapabilityType.BROWSER_NAME, browser);

        androidDriver = new AndroidDriver(new URL(appiumURL), options);
        log.info("Successfully start an Appium session with: ");

        log.info(((RemoteWebDriver) androidDriver).getCapabilities().toString());
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String rawUrl = url.length > 0 ? url[0] : "";
        if (rawUrl != null && !rawUrl.isEmpty()) {
            log.info("Go to URL: " + rawUrl);
        } else {
            log.info("Next step should be go to URL");
        }
    }

    public void openApplication(String appiumURL, String platformName, String platformVersion, String udid, String appPackage, String appActivity) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("udid", udid);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);

        try {
            androidDriver = new AndroidDriver(new URL(appiumURL), caps);
            log.info("Successfully start an Appium session with: ");
            log.info(((RemoteWebDriver) androidDriver).getCapabilities().toString());
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
            log.error(e.getMessage());
        }
    }

    public void closeApplication() {
        log.info("Close Application and Terminate the session");
        androidDriver.close();
//        androidDriver.quit();
    }

    public void goToUrl(String url) {
        androidDriver.get(url);
    }

    public void tap(By by) {
        WebElement element = androidDriver.findElement(by);
        TouchAction action = new TouchAction<>(androidDriver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).release().perform();
    }

    public void tapAtPosition(int x, int y) {
        TouchAction action = new TouchAction<>(androidDriver);
        action.tap(PointOption.point(x, y)).release().perform();
    }

    public void longPress(By by) {
        WebElement element = androidDriver.findElement(by);
        TouchAction action = new TouchAction<>(androidDriver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .release().perform();
    }

    public void longPressAtPosition(int x, int y) throws InterruptedException {
        TouchAction action = new TouchAction<>(androidDriver);
        action.longPress(PointOption.point(x, y)).release().perform();
    }

    public void swipe(int startX, int startY, int endX, int endY) {
        TouchAction action = new TouchAction<>(androidDriver);
        action.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public void scrollLeftMenuToElement(By by) throws InterruptedException {
        while (androidDriver.findElements(by).size() == 0) {
            log.info("Scroll down to element");
            swipe(165, 2508, 165, 1000);
            Thread.sleep(1000);
        }
    }

    public void scroll(double startY, double endY) {
        Dimension size = androidDriver.manage().window().getSize();
        int startYByPercent = (int) (size.height * startY);
        int endYByPercent = (int) (size.height * endY);
        int xStartEnd = (int) (size.width / 2); // lấy điểm chính giữa màn hình
        swipe(xStartEnd, startYByPercent, xStartEnd, endYByPercent);
    }

    public void scrollDownToElement(By by) throws InterruptedException {
        while (androidDriver.findElements(by).size() == 0) {
            log.info("Scroll down to element");
            scroll(0.8, 0.2);
            Thread.sleep(1000);
        }
    }

    public void takeScreenShot(String pathName, String fileName) throws IOException {
//        Chup toan man hinh dien thoai, luu du lieu vao doi tuong kieu File, ten screenShot
        File screenShot = androidDriver.getScreenshotAs(OutputType.FILE);
//        Khoi tao duong dan luu file anh chup mn hinh
        File location = new File(pathName);
//        Khai bao duong dan day du, gom:; Duong dan + Ten file
        String screenShotName = location.getAbsolutePath() + File.separator + fileName + ".png";
//        Copy du lieu tho trong doi tuong screenShot, luu vao File theo duong dan da luu trong bien screenShot
        FileUtils.copyFile(screenShot, new File(screenShotName));
    }

    public void switchToLandscape() {
//        Ngang
        androidDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void switchToPortrait() {
//        Chuyen sang doc man hinh
        androidDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void installApp(String appPath) {
        androidDriver.installApp(appPath);
    }

    public void setText(By by, String text) {
        WebElement element = androidDriver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By by) {
        return androidDriver.findElement(by).getText();
    }

    //    ============== Wait Keyword ==============
    public void waitElementVisible(By by, long timeOut) {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //    ============== Verify Keyword ==============
    public boolean checkElementPresent(By by) {
        List<WebElement> elements = androidDriver.findElements(by);
        int elementAmount = elements.size();
        if (elementAmount > 0) {
            return true;
        } else {
            return false;
        }
//        boolean isPresent = elementAmount > 0 ? true : false;
    }


    @Test
    public void TC01() throws InterruptedException {
        startApplication("http://127.0.0.1:4723/", "platformName=android", "platformVersion=11", "udid=192.168.225.103:5555",
                "appPackage=com.example.hybridtestapp", "appActivity=com.example.hybridtestapp.MainActivity");
        Thread.sleep(7000);
        closeApplication();
    }

    @Test
    public void TC02() throws InterruptedException {
        openApplication("http://127.0.0.1:4723/", "android", "11", "192.168.225.103:5555",
                "com.example.hybridtestapp", "com.example.hybridtestapp.MainActivity");
        Thread.sleep(7000);
        closeApplication();
    }
}
