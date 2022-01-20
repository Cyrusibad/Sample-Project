package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.List;

public class APSearch {

    WebDriver driver;
    Actions action;

    public APSearch(WebDriver driver){
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    @FindBy(css = ".ajax_add_to_cart_button")
    List<WebElement> AddToCartBtn;
    @FindBy(css = ".ajax_block_product") List<WebElement> Results;

    public void clickAddToCartBtn(){
        AddToCartBtn.get(1).click();
    }
    public void verifyResult(){
        System.out.println(Results.get(1).getText());
    }
}
