import org.testng.annotations.Test;

@Test
public class HomePageTests extends SetUp {
    HomePage homePage;
    LoginPage loginPage;

    public void createMeeting() {
        loginPage = new LoginPage(driver);

        loginPage.addEmail("Mohammed.nabil4004@gmail.com");
        loginPage.addPass("123456Mm");
        homePage=loginPage.clickSignIn();
        homePage.createQuickMeeting("123");

    }
}
