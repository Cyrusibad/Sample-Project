package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APPayment {
    WebDriver driver;

    public APPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cheque")
    WebElement PayByCheck;

    public void clickPayByCheque() {
        PayByCheck.click();
    }
}
