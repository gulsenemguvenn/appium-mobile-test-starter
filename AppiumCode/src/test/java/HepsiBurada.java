import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class HepsiBurada {

    public static void main(String[] args) throws Exception {

        //Driver ayarları
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");

        //Kurulu uygulamayı aç
        options.setAppPackage("com.pozitron.hepsiburada");
        options.setAppActivity("com.hepsiburada.ui.home.SuperAppActivity");
        options.setAutoGrantPermissions(true);

        // Appium Desktop -> /wd/hub
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ Uygulama açıldı");


        Thread.sleep(3000); // ekranın oturması için kısa bekleme

        //  Popup / buton varsa tıkla
        try {
            WebElement button = driver.findElement(By.xpath("(//android.widget.Button)[1]"));
            button.click();
            System.out.println(" Popup butonuna tıklandı");
        } catch (Exception e) {
            System.out.println(" Popup butonu bulunamadı, devam");
        }

        Thread.sleep(2000);

        // Arama kutusuna tıkla
        WebElement searchBox = driver.findElement(By.id("com.pozitron.hepsiburada:id/etSearchBox"));
        searchBox.click();
        System.out.println("✅ Arama kutusuna tıklandı");

        // EditText alanına yazı yaz
        WebElement searchText = driver.findElement(By.className("android.widget.EditText"));
        searchText.sendKeys("Karaca fincan takımı");
        System.out.println("✅ Arama metni yazıldı");


        // driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        // driver.quit();

    }
}