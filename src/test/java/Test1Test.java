import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Test1Test {
    @Test
    public void site_header_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver browser;
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browser.get("http://saucelabs.com");
        WebElement header = browser.findElement(By.className("nav-image-link"));
        assertTrue(header.isDisplayed());
        header.click();

        WebElement search = browser.findElement(By.className("nav-action-list-items-search-form"));
        WebElement contact = browser.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[1]/div/a"));
        search.click();
        WebElement sinput = browser.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[3]/ul/li[4]/form/div/input"));
        sinput.sendKeys("asd");
        WebElement cs = browser.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[6]/div[2]/div/div/div/ul/li/div/ul/li[1]/div/ul/li[1]/div/ul/li/a/span"));
        Actions action = new Actions(browser);
        action.moveToElement(contact);
        action.moveToElement(cs);
        action.click().build().perform();
        browser.findElement(By.className("nav-image-link")).click();
    }
}