package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpTravelsLogin {

    WebDriver driver;

    public PhpTravelsLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password") WebElement password;
    @FindBy(linkText = "Login") WebElement LoginBtn;

    public void enterEmail(String arg1){
        email.sendKeys(arg1);
    }

    public void enterPass(String arg2){
        password.sendKeys(arg2);
    }

    public void clickLoginBtn(){
        LoginBtn.click();
    }
}
