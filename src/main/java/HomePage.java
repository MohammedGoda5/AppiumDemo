import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {
    private final AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    private final By meetingTitleField = AppiumBy.xpath("//android.widget.EditText");
    private final By quickMeetingButton = AppiumBy.accessibilityId("Create Meeting");
    private final By plusIcon = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button");
    private final By instantMeetingV3 = AppiumBy.accessibilityId("V.connct 3 (New)");
    private final By scheduleMeetingV3 = AppiumBy.accessibilityId("schedule V.connct 3 (New)");
    private final By instantMeetingTitle = AppiumBy.androidUIAutomator("new UiSelector().className(\'android.widget.EditText\').instance(0)");
    private final By passwordField = AppiumBy.androidUIAutomator("new UiSelector().className(\'android.widget.EditText\').instance(1)");

    public void createQuickMeeting(String title) {
        driver.findElement(meetingTitleField).click();
        driver.findElement(meetingTitleField).sendKeys(title);
        driver.findElement(quickMeetingButton).click();

    }


}