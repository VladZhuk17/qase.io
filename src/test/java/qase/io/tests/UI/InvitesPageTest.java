package qase.io.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.Member;
import qase.io.UI.model.User;
import qase.io.UI.services.InvitesPageService;
import qase.io.UI.services.LoginPageService;

public class InvitesPageTest extends BaseTest {

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test
    @Parameters({"emailMember","nameMember", "roleTitleMember"})
    public void verifyInviteMemberTest(String emailMember, String nameMember, String roleTitleMember) {
        Member member = Member.builder().email(emailMember).name(nameMember).roleTitle(roleTitleMember).build();
        InvitesPageService invitesPageService = new InvitesPageService();
        boolean actualMemberEmail = invitesPageService.inviteMember(member).isSuccessfulCreateMember();
        Assert.assertTrue(actualMemberEmail);
    }
}
