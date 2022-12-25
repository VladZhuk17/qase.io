package qase.io.UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDown extends BaseElements {

    private static final String DROP_DOWN_XPATH = "//div[@class=' css-1hwfws3']";
    private static final String DROP_DOWN_SELECT = ""; //пока не получилось найти =((
    private String label;

    public DropDown(String label){
        this.label=label;
    }

    public void selectOption(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DROP_DOWN_XPATH))).click();
        driver.findElement(By.xpath(String.format(DROP_DOWN_SELECT, option))).click();
    }

}
