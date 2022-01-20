import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TheInternet {

    @Test
    public void BasicAuth() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://" + "admin" + ":" + "admin" + "@" + "the-internet.herokuapp.com/basic_auth");
        driver.switchTo().alert().sendKeys("admin" + Keys.TAB + "admin");
        driver.switchTo().alert().accept();
    }
}
