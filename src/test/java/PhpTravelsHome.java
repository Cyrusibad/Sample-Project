package test;
import com.thoughtworks.selenium.webdriven.commands.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.lang.annotation.Inherited;
import java.util.List;

public class PhpTravelsHome {

    WebDriver driver;
    Actions action;

    public PhpTravelsHome(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    @FindBy(className = "select2-search__field")
    public WebElement CityName;
    @FindBy(id = "checkin")
    WebElement CheckIn;
    WebElement CheckinDateTable = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody"));
    List<WebElement> CheckinDateRow = CheckinDateTable.findElements(By.tagName("tr"));
    @FindBy(id = "checkout")
    WebElement CheckOut;
    @FindBy(className = "dropdown-toggle dropdown-btn travellers waves-effect")
    WebElement Travellers;
    @FindBy(id = "submit")
    WebElement SearchButton;
    @FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[1]/div/div/div/span/span[1]/span") WebElement SearchByCity;
    @FindBy(css = ".select2-results__option--highlighted")
    WebElement CityResult;


    By searchCity = By.className("select2-results__option");
    By city1 = By.className("select2-search__field");


    public void  enterSearchByCity(String city){
        /*driver.findElement(searchCity).click();
        driver.findElement(city1).sendKeys(city);
        CityResults.get(1).click();
         */

        SearchByCity.click();
        CityName.sendKeys(city);
        action.moveToElement(CityResult);
        action.click().build().perform();
    }

    public void SetCheckinDate(String day){
        CheckIn.click();
        for(int i = 0; i <= CheckinDateRow.size();i++){
            List<WebElement> Column = CheckinDateRow.get(i).findElements(By.tagName("td"));
            for(int j=0;j<= Column.size();j++){
                if(Column.get(j).getText()==day){
                    Column.get(j).click();
                }
                break;
            }
        }
    }

}
