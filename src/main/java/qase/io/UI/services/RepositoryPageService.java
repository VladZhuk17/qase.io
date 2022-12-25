package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.Project;
import qase.io.UI.model.Suite;
import qase.io.UI.pages.RepositoryPage;

public class RepositoryPageService {

    @Step("Create new suite")
    public RepositoryPage createNewSuite (Project project, String suiteName){
        Suite suite = Suite.builder().suiteName(suiteName).build();
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.openRepositoryPage(project)
                .clickOnButtonAddNewSuite()
                .fillSuiteName(suite)
                .clickOnButtonCreateSuite();
        return new RepositoryPage();
    }

    @Step("Delete suite" )
    public RepositoryPage deleteSuite (Project project, Suite suite){
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.openRepositoryPage(project)
                .clickOnSettingSuite(suite)
                .clickOnDeleteSuite()
                .clickOnButtonSubmitDeleteSuite();
        return new RepositoryPage();
    }


}
