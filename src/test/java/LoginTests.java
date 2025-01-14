import org.testng.annotations.Test;

@Test
public class LoginTests extends SetUp {
    @Test
    public void testSuccessfullLogin() {
        loginPage = new LoginPage(driver);
        loginPage.addEmail("Mohammed.nabil4004@gmail.com");
        loginPage.addPass("123456Mm");
        loginPage.clickSignIn();
    }


}
