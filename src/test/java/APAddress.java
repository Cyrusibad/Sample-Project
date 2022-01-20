package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APAddress {

    WebDriver driver;

    public APAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement ProceedToCheckoutBtn;
    @FindBy(css = ".page-heading") public WebElement Heading;

    public void clickProceedToCheckoutBtn() {
        ProceedToCheckoutBtn.click();
    }

}
