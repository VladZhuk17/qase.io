package qase.io.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.model.Tags;
import qase.io.model.User;
import qase.io.services.LoginPageService;
import qase.io.services.TagsPageService;

public class TagsPageTest {

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test(description = "Create a new tag")
    @Parameters({"tagName"})
    public void verifyCreateNewTag(String tagName) {
        Tags tags = Tags.builder().tagName(tagName).build();
        TagsPageService tagsPageService = new TagsPageService();
        boolean isSuccessfulCreateTag = tagsPageService.createNewTag(tags)
                .isSuccessfulCreateTag(tags);
        Assert.assertTrue(isSuccessfulCreateTag);
    }

    @Test(description = "Delete the tag")
    @Parameters({"tagName"})
    public void verifyDeleteTag(String tagName){
        Tags tags = Tags.builder().tagName(tagName).build();
        TagsPageService tagsPageService = new TagsPageService();
       boolean isSuccessfulDeleteTag = tagsPageService.deleteTag(tags)
               .isSuccessfulDeleteTag(tags);
       Assert.assertTrue(isSuccessfulDeleteTag);
    }
}
