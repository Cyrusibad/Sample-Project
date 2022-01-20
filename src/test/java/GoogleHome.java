package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHome {

    WebDriver driver;

    public GoogleHome(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input.gLFyf.gsfi")
    WebElement SearchBar;

    @FindBy(css = "input.gNO89b") WebElement GoogleSearchButton;

    public void enterSearch(String search){
        SearchBar.sendKeys(search);
    }

    public void clickSearchButton(){
        GoogleSearchButton.click();
    }
}
