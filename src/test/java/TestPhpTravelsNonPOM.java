import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import test.DriverSetup;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestPhpTravelsNonPOM extends DriverSetup {

    @Test
    public void testFlightsTab() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://www.phptravels.net");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/ul/li[2]/button")).click();
        driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div[2]/div/input")).click();
        driver.findElement(By.id("autocomplete")).sendKeys("miami");
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[1]/div/div/div/div/div[1]")).click();
        driver.findElement(By.id("autocomplete2")).sendKeys("london");
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[2]/div/div/div/div/div[1]")).click();
        driver.findElement(By.id("departure")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr[3]/td[4]")).click();
        driver.findElement(By.id("return")).click();
        driver.findElement(By.xpath("//*[@id=\"return\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"return\"]")).sendKeys("28-09-2021");
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")).click();
        driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/a")).click();
        driver.findElement(By.id("flights-search")).click();
        driver.close();


    }

    @Test

    public void testHotelTab() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://www.phptravels.net/login");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys("user@phptravels.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("demouser" + Keys.ENTER);
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div/div[1]/div/div/div/span/span[1]/span")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("miami");
        WebElement country = driver.findElement(By.cssSelector(".select2-results__option--highlighted"));
        action.moveToElement(country);
        action.click().build().perform();

        SetCheckinDate("16");
        SetCheckoutDate("18");
        /*action.moveToElement(driver.findElement(By.cssSelector(".day.active")));
        action.click().build().perform();

         */
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    }

    @Test
    public void testToursTab(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://www.phptravels.net/login");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys("user@phptravels.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("demouser" + Keys.ENTER);
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.id("tours-tab")).click();
        driver.findElement(By.xpath("//*[@id=\"tours-search\"]/div/div/div[1]/div/div/div/span/span[1]/span")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("miami");
        WebElement country = driver.findElement(By.cssSelector(".select2-results__option--highlighted"));
        action.moveToElement(country);
        action.click().build().perform();
        driver.findElement(By.id("date")).click();
        String day = "30";
        List<WebElement> column = driver.findElements(By.cssSelector(".day.active"));
        for (int i = 0; i < column.size(); i++) {
            String text = driver.findElements(By.cssSelector(".day.active")).get(i).getText();
            if (text.equalsIgnoreCase(day)) {
                driver.findElements(By.cssSelector(".day.active")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("submit")).click();
    }

    public void SetCheckinDate(String day) {
        WebElement CheckIn = driver.findElement(By.id("checkin"));
        CheckIn.click();
        List<WebElement> column = driver.findElements(By.className("day"));
        for (int i = 0; i < column.size(); i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase(day)) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }
    }

    public void SetCheckoutDate(String day) {
        WebElement CheckIn = driver.findElement(By.id("checkout"));
        CheckIn.click();
        List<WebElement> column = driver.findElements(By.className("day"));
        for (int i = 0; i < column.size(); i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase(day)) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }
    }
}
