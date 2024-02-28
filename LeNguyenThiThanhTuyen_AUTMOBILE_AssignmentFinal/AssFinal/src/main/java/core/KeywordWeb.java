package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class KeywordWeb {
    private static WebDriver webDriver;

    public KeywordWeb() {
    }
    //ACTION KEYWORD

    public void openBrowser(String browser, String... url) {
        System.out.println("Open Browser " + browser);
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                webDriver = new ChromeDriver();
                break;
            case "CHROME HEADLESS":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "FIREFOX HEADLESS":
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.printf("Unsupported browser " + browser);
                break;
        }
        System.out.println("Successfully open browser " + browser);
        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5).toMillis(), TimeUnit.SECONDS);
        // kiem tra do dai mang > 0?
        // ["https://demoqa.com"] = 1 > 0 => true, lay ra string cua phan tu co index = 0 va luu vao rawURL
        // [""] = 0 => false, gan string empty vao bien rawURL
        String rawURL = url.length > 0 ? url[0] : "";
        if (rawURL != null && !rawURL.isEmpty()) {
            System.out.println("Go to URL: " + rawURL);
            webDriver.get(rawURL);
        } else {
            System.out.println("Next step should be go to URL");
        }

    }

    public void closeBrowser() {
        System.out.println("Close browser: ");
        webDriver.quit();
    }

    public void clickElement(By by) {
        webDriver.findElement(by).click();
    }

    //Verify keyword
    public void takeScreenShot(String imgName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) webDriver;///khoi tao
        File fileSource = ts.getScreenshotAs(OutputType.FILE);//chup anh man hinh
        File dir = new File("./report/");//khoi tao thu muc de luu tru anh
        if (!dir.exists()) {//kiem tra co thu muc khong
            boolean mkdirs = dir.mkdirs();//tao thu muc
        }
        String path = "./report/" + imgName + ".png";
        FileHandler.copy(fileSource, new File(path));
        System.out.println("Screenshot is saved at " + path);
    }
//    public void takeScreenshotUsingRobot(String imgName) throws AWTException, IOException {
//        Robot robot = new Robot();
//        Rectangle size = new Rectangle(getDefaultToolkit().getScreenSize());
//        BufferedImage image = new Robot().createScreenCapture(new Rectangle(getDefaultToolkit().getScreenSize()));
//        ImageIO.write(image, "png", new File("./report/" + imgName + ".png"));
//    }


    //    public boolean isPresent(By by){
//        try{
//            webDriver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e){
//            return false;
//        }
//    }
//
    public boolean isPresent(By by) {
        List<WebElement> element = webDriver.findElements(by);
        if (element.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void verifyPageShouldContainText(String text) {
        String bodyText = webDriver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(text), "Text not found");
    }

    public void verifyPageShouldNotContainText(String text) {
        String bodyText = webDriver.findElement(By.tagName("body")).getText();
        //  Assert.assertTrue(bodyText.contains(text),"Text not found"); //cach nay khong dam bao clean code
        Assert.assertFalse(bodyText.contains(text), "Text not found");
    }
    //web keyword

    //c1
    public void webElementPresent(By by, long timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOut));// khoi tao dk wait
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    //c2
    public void waitElementPresentWithPolling(String locator, Duration timeOut) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(timeOut).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(locator));
            }
        });
    }

    public void waitElementAttribute(String locator, String attribute, String expected, Duration timeOut) {

        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(locator)).getAttribute(attribute).contains(expected);
            }
        });

    }

    public void waitAlertPresent(By by, Duration timeOut) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void setText(By by, String text) {
        WebElement element = webDriver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    //    public void scrollUp(int pixels){
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("window.scrollBy(0,arguments[0])", pixels);
//    }
//    public void scrollDown(int pixels){
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("window.scrollBy(0,arguments[0])", -pixels);
//    }
    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,arguments[0])", pixels);
    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,arguments[0])", -pixels);
    }

    public String getText(String locator) {
        return webDriver.findElement(By.xpath(locator)).getText();
    }

    public void selectOptionByValue(By by, String value) {
        Select dropDown = new Select(webDriver.findElement(by));
        dropDown.selectByValue(value);
    }
}
