package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.Group;
import qase.io.UI.pages.GroupsPage;

public class GroupsPageService {
    @Step("Create a new user group")
    public GroupsPage createGroup(Group group) {
        GroupsPage groupsPage = new GroupsPage();
        groupsPage.openGroupsPage()
                .clickOnCreateNewGroup()
                .fillGroupTitle(group.getGroupTitle())
                .fillTextareaGroupDescription(group.getGroupDescription())
                .clickOnButtonCreate();
        return new GroupsPage();
    }
    @Step("Delete group")
    public GroupsPage deleteGroup(Group group){
        GroupsPage groupsPage = new GroupsPage();
        groupsPage.openGroupsPage().clickOnGroupDropdown(group).clickOnButtonDelete(group).clickOnButtonDeleteGroup();
        return new GroupsPage();
    }
}
