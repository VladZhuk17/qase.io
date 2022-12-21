package qase.io.tests.UI;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.User;
import qase.io.UI.services.LoginPageService;

public class LoginPageTest extends BaseTest{

    private static final String URL_PROJECTS_PAGE = "https://app.qase.io/projects";

    @Test(description = "Log in a user")
    @Parameters({"userEmail", "userPassword"})
    public void loginTest(String userEmail, String userPassword){
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder().email(userEmail).password(userPassword).build();
        loginPageService.login(user);
        String actualText = driver.getCurrentUrl();;
        String expectedText = URL_PROJECTS_PAGE;
        Assert.assertEquals(actualText, expectedText);
    }
}
