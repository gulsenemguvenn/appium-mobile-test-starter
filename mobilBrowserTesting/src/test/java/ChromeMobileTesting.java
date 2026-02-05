import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AutomationName;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class ChromeMobileTesting {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {

        MutableCapabilities caps = new MutableCapabilities();

        //  temel bilgiler
        caps.setCapability("platformName", "Android");

        // Appium 2
        caps.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability("appium:deviceName", "Pixel");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:newCommandTimeout", 60);

        //  Chrome uygulamasını native olarak açmak için
        caps.setCapability("appium:appPackage", "com.android.chrome");
        caps.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");


        caps.setCapability("appium:chromedriverAutodownload", true);

        URL serverUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(serverUrl, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openAmazonViaChromeApp() {

        // Chrome açıldıktan sonra arama/adres kutusu.

        WebElement addressBox = driver.findElement(By.id("com.android.chrome:id/search_box_text"));
        addressBox.click();
        addressBox.sendKeys("https://www.amazon.com.tr");


        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        // Web sayfası açılınca logo kontrolü
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed(), "Amazon logosu görünmüyor!");

        System.out.println(" Chrome app ile Amazon açıldı ve logo doğrulandı");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Driver kapatıldı");
        }
    }
}
