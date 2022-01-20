package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.LgnPage;

public class testLgnPage {

    public static void main(String[] Args) {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

        LgnPage Login = new LgnPage(driver);

        driver.manage().window().maximize();

        Login.enterUser("opensourcecms");
        Login.enterPass("opensourcecms");
        Login.clickLogin();
    }
}
