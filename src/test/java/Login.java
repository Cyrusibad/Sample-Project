import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Login {
    @Test
    public void login() {
        WebDriver browser;
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        browser = new ChromeDriver();
        String user = "opensourcecms";
        String pass = "opensourcecms";
        browser.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
        WebElement userText = browser.findElement(By.id("user_login"));
        WebElement passText = browser.findElement(By.id("user_pass"));
        WebElement loginBtn = browser.findElement(By.id("wp-submit"));
        browser.manage().window().maximize();
        userText.sendKeys(user);
        passText.sendKeys(pass);
        loginBtn.click();
        browser.close();
    }
}
