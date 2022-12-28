package qase.io.UI.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import qase.io.UI.model.Group;
import qase.io.UI.pages.GroupsPage;

@Log4j2
public class GroupsPageService {
    @Step("Create a new user group")
    public GroupsPage createGroup(Group group) {
        log.info("INFO: create a new group");
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
        log.info("INFO: delete the group");
        GroupsPage groupsPage = new GroupsPage();
        groupsPage.openGroupsPage().clickOnGroupDropdown(group).clickOnButtonDelete(group).clickOnButtonDeleteGroup();
        return new GroupsPage();
    }
}
