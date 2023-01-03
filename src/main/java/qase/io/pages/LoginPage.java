package qase.io.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.model.User;

@Log4j2
public class LoginPage extends BasePage {

    private static final String URL_LOGIN_PAGE = "https://app.qase.io/login";

    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[@data-qase-test='sign-up-button']")
    private WebElement buttonSignUp;

    public LoginPage openLoginPage() {
        log.info("INFO: open Login page");
        driver.get(URL_LOGIN_PAGE);
        return this;
    }

    public LoginPage fillEmailField(User user) {
        log.info("INFO: fill email field");
        email.sendKeys(user.getEmail());
        return this;
    }

    public LoginPage fillPasswordField(User user) {
        log.info("INFO: fill password field");
        password.sendKeys(user.getPassword());
        return this;
    }

    public void clickOnButtonLogin() {
        log.info("INFO: click on button login");
        buttonLogin.click();
    }
}
