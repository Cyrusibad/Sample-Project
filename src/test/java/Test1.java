import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("goog"+ Keys.ENTER);
    }
}
