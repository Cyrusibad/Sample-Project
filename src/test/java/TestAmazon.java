import io.cucumber.java.da.Men;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAmazon {

    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.amazon.in");
        String home = driver.getTitle();
        System.out.println(home);
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[9]")).click();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("nav-logo-sprites")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),home);

    }
}
