package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.Collections;

public class Homepages {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public Homepages() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your tickets\nwhere and whenever you want!']")
    private WebElement homeTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Later']")
    private WebElement laterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You can make purchases up to 50€, but to save a card you must create an account.\"]")
    private WebElement termsText;

    @AndroidFindBy(xpath = "//android.widget.Image[@text='checked Terms/Conditions']")
    private WebElement termsCheckbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement okButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Why enable geolocation?']")
    private WebElement geolocationTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"OK, got it!\"]")
    private WebElement geolocationOkButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowPermissionButton;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement networkSearchInput;


    private void click(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
    }

    private boolean isVisible(WebElement el) {
        try {
            wait.until(ExpectedConditions.visibilityOf(el));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void verifyHomeTitleIsVisible() {
        Assert.assertTrue("Home title is not visible!", isVisible(homeTitle));
    }

    public void clickLater() {
        click(laterButton);
    }

    public void verifyTermsTextIsVisible() {
        Assert.assertTrue("Terms text is not visible!", isVisible(termsText));
    }

    public void acceptTermsIfNeeded() {
        click(termsCheckbox);
        if (isVisible(okButton)) {
            click(okButton);
        }
    }

    public void confirmGeolocationIfVisible() {
        if (isVisible(geolocationTitle)) {
            click(geolocationOkButton);
        }
    }

    public void allowPermissionIfVisible() {
        if (isVisible(allowPermissionButton)) {
            click(allowPermissionButton);
        }
    }


    public void tapCheckLaterByCoordinates() {
        tapByCoordinates(620, 2150);
    }

    private void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }

    public void searchNetwork(String text) {
        click(networkSearchInput);
        networkSearchInput.clear();
        networkSearchInput.sendKeys(text);
    }
}
