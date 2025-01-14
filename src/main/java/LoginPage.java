import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private final AndroidDriver driver;

    private final By emailAdress = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
    private final By password = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
    private final By signIn = AppiumBy.accessibilityId("Sign In");


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }


    public void addEmail(String email) {
        driver.findElement(emailAdress).click();
        driver.findElement(emailAdress).clear();
        driver.findElement(emailAdress).sendKeys(email);
    }

    public void addPass(String Password) {
        driver.findElement(password).click();
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(Password);
    }

    public HomePage clickSignIn() {
        driver.findElement(signIn).click();
        return new HomePage(driver);
    }

}
