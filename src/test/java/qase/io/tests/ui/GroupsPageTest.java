package qase.io.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.model.Group;
import qase.io.model.User;
import qase.io.services.GroupsPageService;
import qase.io.services.LoginPageService;
import qase.io.utils.Retry;

public class GroupsPageTest extends BaseTest{

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test(description = "create a new group ", retryAnalyzer = Retry.class)
    @Parameters({"groupTitle", "groupDescription"})
    public void verifyCreateNewGroupTest(String groupTitle, String groupDescription){
        Group group = Group.builder()
                .groupTitle(groupTitle)
                .groupDescription(groupDescription)
                .build();
        GroupsPageService groupsPageService = new GroupsPageService();
        boolean isSuccessfulCreateGroup = groupsPageService.createGroup(group)
                .isSuccessfulCreateGroup(group);
        Assert.assertTrue(isSuccessfulCreateGroup);
    }

    @Test(description = "delete the group ", retryAnalyzer = Retry.class)
    @Parameters({"groupForDelete"})
    public void verifyDeleteGroupTest(String groupForDelete){
        Group group = Group.builder().
                groupTitle(groupForDelete)
                .build();
        GroupsPageService groupsPageService = new GroupsPageService();
        boolean isSuccessfulDeleteGroup = groupsPageService.deleteGroup(group)
                .isSuccessfulDeleteGroup(group);
        Assert.assertTrue(isSuccessfulDeleteGroup);

    }
}
