package qase.io.UI.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qase.io.UI.driver.DriverSingleton;
import java.time.Duration;

public class BaseElements {

    private static final int WAIT_ELEMENT = 15;
    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_ELEMENT));
}
