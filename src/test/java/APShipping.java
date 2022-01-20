package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APShipping {

    WebDriver driver;

    public APShipping(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cgv")
    WebElement TermsOfServiceCheckbox;
    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement ProceedToCheckoutBtn;

    public void clickTermsOfServiceCheckbox() {
        TermsOfServiceCheckbox.click();
    }

    public void clickProceedToCheckoutBtn() {
        ProceedToCheckoutBtn.click();
    }

}
