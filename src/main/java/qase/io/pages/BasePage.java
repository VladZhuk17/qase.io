package qase.io.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qase.io.driver.DriverSingleton;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    public static final int WAIT_ELEMENT = 15;

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitElement (WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_ELEMENT)).until(ExpectedConditions.visibilityOf(element));
    }
}
