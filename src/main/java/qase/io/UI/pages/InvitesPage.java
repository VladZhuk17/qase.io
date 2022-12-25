package qase.io.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvitesPage extends BasePage {

    private static final String URL_INVITES_PAGE = "https://app.qase.io/workspace/invites";

    @FindBy(xpath = "//a[text()='Invite new member']")
    WebElement buttonInviteNewMember;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonInvite;

    @FindBy(xpath = "//span[text()='User has been successfully invited']")
    WebElement textIsSuccessfulCreateMember;

    public InvitesPage openInvitesPage() {
        driver.get(URL_INVITES_PAGE);
        return this;
    }

    public void clickOnButtonInviteNewMember() {
        buttonInviteNewMember.click();
    }

    public void clickOnButtonInvite() {
        buttonInvite.click();
    }

    public boolean isSuccessfulCreateMember() {
        boolean isSuccessfulCreateMember = waitElement(textIsSuccessfulCreateMember).isDisplayed();
        return true;
    }
}
