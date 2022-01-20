package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APLoginPage {

    WebDriver driver;

    public APLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement Email;
    @FindBy(id = "passwd")
    WebElement Pass;
    @FindBy(id = "SubmitLogin")
    WebElement LoginBtn;

    public void enterUser(String email) {
        Email.sendKeys(email);
    }

    public void enterPass(String pass) {
        Pass.sendKeys(pass);
    }

    public void clickLogin() {
        LoginBtn.click();
    }
}
