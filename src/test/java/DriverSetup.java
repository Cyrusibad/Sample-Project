package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public WebDriver driver;
    public WebDriverWait wait;
    public DriverSetup(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
