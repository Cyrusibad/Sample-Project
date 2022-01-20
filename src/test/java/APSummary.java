package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class APSummary {

    WebDriver driver;

    public APSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement ProceedToCheckoutBtn;

    @FindBys(@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[6]"))
    public List<WebElement>UnitPrice;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tfoot/tr[7]/td[2]/span") public WebElement TotalPrice;

    public void clickProceedToCheckoutBtn() {
        ProceedToCheckoutBtn.click();
    }

}
