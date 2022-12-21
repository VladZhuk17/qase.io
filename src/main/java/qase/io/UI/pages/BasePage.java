package qase.io.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import qase.io.UI.driver.DriverSingleton;
import qase.io.UI.utils.TestListener;
import java.time.Duration;

@Listeners(TestListener.class)
public class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    public int WAIT_ELEMENT = 15;

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitElement (WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_ELEMENT)).until(ExpectedConditions.visibilityOf(element));
    }

    @BeforeClass
    public void startBrowser(){
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.getInstance().closeDriver();
    }
}
