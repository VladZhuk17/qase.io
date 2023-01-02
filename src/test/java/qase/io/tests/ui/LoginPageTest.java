package qase.io.tests.ui;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.model.User;
import qase.io.services.LoginPageService;
import qase.io.utils.Retry;

public class LoginPageTest extends BaseTest{

    private static final String URL_PROJECTS_PAGE = "https://app.qase.io/projects";

    @Test(description = "Log in user", retryAnalyzer = Retry.class)
    @Parameters({"userEmail", "userPassword"})
    public void verifyLoginTest(String userEmail, String userPassword){
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email(userEmail)
                .password(userPassword)
                .build();
        loginPageService.login(user);
        String actualText = driver.getCurrentUrl();
        String expectedText = URL_PROJECTS_PAGE;
        Assert.assertEquals(actualText, expectedText);
    }
}
