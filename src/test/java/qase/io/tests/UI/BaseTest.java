package qase.io.tests.UI;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import qase.io.UI.driver.DriverSingleton;
import qase.io.UI.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
    }

  //  @AfterClass(alwaysRun = true)
  //  public void stopBrowser() {
 //   DriverSingleton.getInstance().closeDriver();
 //   }
}
