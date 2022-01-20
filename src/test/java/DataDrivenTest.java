import Utilities.Constants;
import Utilities.ExcelUtils;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDrivenTest {

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = "D:\\TestData.xlsx";

    public static void main(String []args) throws IOException {
        System.setProperty("webdriver.opera.driver","D:\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement searchbox1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchbox1.sendKeys("qwert" + Keys.ENTER);

        excelUtils.setExcelFile(excelFilePath);
        WebElement searchbox2 = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input"));
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[3]/div[1]"));

        for(int i=0;i<=excelUtils.getRowCountInSheet();i++){
            closeBtn.click();
            searchbox2.sendKeys(excelUtils.getCellData(i,0));
            List<WebElement> result = driver.findElements(By.cssSelector("div.yuRUbf"));
        }

    }
}
