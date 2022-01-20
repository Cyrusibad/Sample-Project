package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APHome {

    WebDriver driver;
    Actions action;

    public APHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    @FindBy(linkText = "T-SHIRTS") WebElement shirts;
    @FindBy(linkText = "DRESSES") WebElement Dresses;
    @FindBy(linkText = "CASUAL DRESSES") WebElement CasualDresses;
    @FindBy(linkText = "EVENING DRESSES") WebElement EveningDresses;
    @FindBy(linkText = "SUMMER DRESSES") WebElement SummerDresses;
    @FindBy(id="search_query_top") WebElement searchBar;
    @FindBy(css = ".button-search") WebElement searchBtn;


    public void clickTShirts() {
        shirts.click();
    }

    public void clickDresses(){
        Dresses.click();
    }

    public void selectCasualDresses(){
        action.moveToElement(Dresses);
        action.moveToElement(CasualDresses);
        action.click().build().perform();
    }

    public void selectEveningDresses(){
        action.moveToElement(Dresses);
        action.moveToElement(EveningDresses);
        action.click().build().perform();
    }

    public void selectSummerDresses(){
        action.moveToElement(Dresses);
        action.moveToElement(SummerDresses);
        action.click().build().perform();
    }

    public void enterSearchBar(String search){
        searchBar.sendKeys(search);
        searchBtn.click();
    }

}
