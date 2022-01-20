import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.DriverSetup;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoWebTable{
    WebDriver driver;

    @Test
    public void RowsCount(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement table = driver.findElement(By.className("tsc_table_s13"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        System.out.println("number of rows:"+ rows_table.size());
        String Structures;
        int totalStruc = 0;

        for(int i = 1; i < rows_table.size()-1;i++){
            Structures = driver.findElement(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[1]/table/tbody/tr["+i+"]/th")).getText();
            System.out.println(Structures);
            totalStruc = i;
        }

        WebElement total = driver.findElement(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[1]/table/tfoot/tr/td"));
        
        Assert.assertEquals(totalStruc+" "+"buildings",total.getText());
        driver.close();
    }
    @Test
    public void printAllData(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement table = driver.findElement(By.className("tsc_table_s13"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("number of rows:"+ rows_count);
        for(int row = 0;row<rows_count;row++){
            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int columns_count = columns_row.size();
            for(int column = 0;column<columns_count;column++){
                String cellText = columns_row.get(column).getText();
                System.out.print("_"+cellText+" ");
            }
            System.out.print("\n");
        }
    }
}
