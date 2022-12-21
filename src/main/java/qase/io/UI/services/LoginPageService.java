package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.User;
import qase.io.UI.pages.LoginPage;
import qase.io.UI.pages.ProjectsPage;

public class LoginPageService {
    @Step("Log in and open Projects Page")
    public ProjectsPage login (User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .fillEmailField(user)
                .fillPasswordField(user)
                .clickOnButtonLogin();
        return new ProjectsPage();
    }
}
