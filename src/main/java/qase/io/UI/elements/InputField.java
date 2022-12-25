package qase.io.UI.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputField extends BaseElements {

    private static final String INPUT_XPATH = "//div[@class='PeaEvB']/child::div/div/input[@id='%s']";
    private String label;

    public InputField(String label) {
        this.label = label;
    }

    public void writeText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(INPUT_XPATH, label))))
                .sendKeys(text);
    }
}
