package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APCheckPayment {

    WebDriver driver;

    public APCheckPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement ConfirmOrderBtn;

    public void clickConfirmOrderBtn() {
        ConfirmOrderBtn.click();
    }

}
