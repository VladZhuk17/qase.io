package qase.io.UI.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import qase.io.UI.model.User;
import qase.io.UI.pages.LoginPage;
import qase.io.UI.pages.ProjectsPage;

@Log4j2
public class LoginPageService {
    @Step("Log in and open Projects Page")
    public ProjectsPage login (User user) {
        log.info("INFO: user login");
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .fillEmailField(user)
                .fillPasswordField(user)
                .clickOnButtonLogin();
        return new ProjectsPage();
    }
}
