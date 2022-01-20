package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APDresses {

    WebDriver driver;

    public APDresses(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/span")
    public WebElement CDCategoryName;

}
