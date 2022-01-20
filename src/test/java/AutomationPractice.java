import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class AutomationPractice {

    @Test
    public void testAutomationPractice() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.com");
        Actions action = new Actions(driver);
        WebElement Tshirts = driver.findElement(By.linkText("T-SHIRTS"));
        wait.until(ExpectedConditions.visibilityOf(Tshirts));
        Tshirts.click();
        driver.findElement(By.id("layered_id_attribute_group_1")).click();
        WebElement Slider1 = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
        WebElement Slider2 = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]"));

        action.clickAndHold(Slider1).moveByOffset(30, 0).release().perform();
        action.clickAndHold(Slider2).moveByOffset(-40, 0).release().perform();

        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")));
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")));
        action.click().build().perform();

        WebElement SMsg = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i"));
        wait.until(ExpectedConditions.visibilityOf(SMsg));
        assertTrue(SMsg.isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        driver.close();
    }

    @Test

    public void testSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("http://Automationpractice.com");
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("shirt");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        List<WebElement> Shirts = driver.findElements(By.xpath("//li[@class='clearfix']"));
        System.out.print(Shirts.get(1).getText());
        Shirts.get(1).click();
        driver.close();
    }

    @Test
    public void testLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("cyry123@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("123asd");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Test
    public void endToEnd() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("cyry123@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("123asd");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.get("http://www.automationpractice.com");
        Actions action = new Actions(driver);
        WebElement Tshirts = driver.findElement(By.linkText("T-SHIRTS"));
        wait.until(ExpectedConditions.visibilityOf(Tshirts));
        Tshirts.click();
        driver.findElement(By.id("layered_id_attribute_group_1")).click();
        WebElement Slider1 = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
        WebElement Slider2 = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]"));

        action.clickAndHold(Slider1).moveByOffset(30, 0).release().perform();
        action.clickAndHold(Slider2).moveByOffset(-40, 0).release().perform();

        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")));
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")));
        action.click().build().perform();

        WebElement SMsg = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i"));
        wait.until(ExpectedConditions.visibilityOf(SMsg));
        assertTrue(SMsg.isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        driver.findElement(By.cssSelector(".cheque")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        WebElement OrderCompleteMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
        Assert.assertTrue(OrderCompleteMessage.isDisplayed());
    }
}
