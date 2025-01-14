import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;
import utils.PropertyReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class SetUp {
    protected  LoginPage loginPage;
    protected AppiumDriverLocalService service;
    protected AndroidDriver driver;
    protected PropertyReader propertyReader;

    @BeforeClass
    public void setUpServer() {
        propertyReader = new PropertyReader("D:\\AppiumDemo\\src\\main\\resources\\environment.properties"); //Path of Environment.Properties;
        service = new AppiumServiceBuilder()
                .usingPort(Integer.parseInt(propertyReader.getProperty("port")))
                .withIPAddress(propertyReader.getProperty("ipAddress"))
                .withArgument(() -> "--use-drivers",propertyReader.getProperty("usingDriver"))
                .build();
        service.start();

    }

    @BeforeMethod
    public void setUpDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(propertyReader.getProperty("device")) ;
      // to save the session on the device
        // options.noReset();
        options.setApp("D:\\Appium_Demo\\src\\test\\resources\\app-release.apk");
        options.setCapability("autoGrantPermissions", true);


        try {
            driver = new AndroidDriver(
                    new URI("http://"
                            + propertyReader.getProperty("ipAddress") + ":" //Must be the same Address Appium is running on
                            + propertyReader.getProperty("port")).toURL(), options);//Must be the same port Appium is running on
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    }

//    @AfterMethod
//    public void quitDriver() {
//        driver.quit();
//    }
//
//    @AfterClass
//    public void quitServer() {
//        service.stop();
//    }

