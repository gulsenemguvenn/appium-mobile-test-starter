import io.appium.java_client.android.AndroidDriver;
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

public class MobileBrowserTesting {

    private AndroidDriver driver;


    // Test başlamadan önce: driver + capability ayarları

    @BeforeTest
    public void setUp() throws Exception {

        MutableCapabilities caps = new MutableCapabilities();

        // ---- Zorunlu temel bilgiler
        caps.setCapability("platformName", "Android");

        // ---- Appium 2'de Appium'a özel capability'ler "appium:" prefix'i ile yazılır
        caps.setCapability("appium:automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability("appium:deviceName", "Pixel");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:newCommandTimeout", 60);

        // ---- Mobil tarayıcı testi (Chrome)
        caps.setCapability("browserName", "Chrome");

        //  Chromedriver path vermiyoruz:
        // Appium, gerekli chromedriver'ı otomatik indirip eşleştirmeye çalışır.
        caps.setCapability("appium:chromedriverAutodownload", true);

        // Appium Server (Appium 2: /wd/hub zorunlu değil)
        URL serverUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(serverUrl, caps);

        // bekleme
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    // Amazon ana sayfayı aç, logo var mı kontrol et

    @Test
    public void openAmazonAndCheckLogo() {

        driver.get("https://www.amazon.com.tr");

        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

        Assert.assertTrue(logo.isDisplayed(), "Amazon logosu görünmüyor!");
        System.out.println(" Amazon açıldı ve logo doğrulandı");
    }


    // Test bitince: driver kapat

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Driver kapatıldı");
        }
    }
}
