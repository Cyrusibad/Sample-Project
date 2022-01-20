import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DemoQA {

    @Test
    public void testAlertButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        driver.close();
    }

    @Test
    public void testALertWithTimer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://www.demoqa.com/alerts");

        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        driver.close();
    }

    @Test
    public void testAlertConfirm() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demoqa.com/alerts");

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        driver.close();
    }

    @Test
    public void testPromptBox() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demoqa.com/alerts");

        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Asdf");
        alert.accept();
    }

    @Test
    public void testFrame() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demoqa.com/frames");

        WebElement Frame1 = driver.findElement(By.id("frame1"));
        WebElement Frame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(Frame2);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(Frame2);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
    }
}
