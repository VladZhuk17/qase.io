package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.elements.InputField;
import qase.io.UI.model.Member;
import qase.io.UI.pages.InvitesPage;

public class InvitesPageService {

    @Step ("Invite new member")
    public InvitesPage inviteMember(Member member) {
        InvitesPage invitesPage = new InvitesPage();
        invitesPage.openInvitesPage()
                .clickOnButtonInviteNewMember();
        new InputField("email").writeText(member.getEmail());
        new InputField("name").writeText(member.getName());
        new InputField("role_title").writeText(member.getRoleTitle());
        invitesPage.clickOnButtonInvite();
    return new InvitesPage();
    }
}