import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class testOtherBrowser {

    @Test
    public void testOperaBrowser(){

        System.setProperty("webdriver.opera.driver","D:\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("opera browser"+ Keys.ENTER);
    }
}
