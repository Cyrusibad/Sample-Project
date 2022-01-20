import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import test.DriverSetup;

public class SauceDemo extends DriverSetup {

    @Test

    public void TestSauceDemo() {
        String user = "standard_user";
        String pass = "secret_sauce";
        driver.manage().window().maximize();
        driver.get("http://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("first");
        driver.findElement(By.id("last-name")).sendKeys("last");
        driver.findElement(By.id("postal-code")).sendKeys("12314");
        driver.findElement(By.id("continue")).click();
        WebElement total = driver.findElement(By.cssSelector(".summary_total_label"));
        Assert.assertEquals("Total: $97.17", total.getText());
        System.out.print(total.getText());
        driver.findElement(By.id("finish")).click();
        WebElement ThankYouHeader = driver.findElement(By.cssSelector(".complete-header"));
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", ThankYouHeader.getText());
        driver.close();
    }

    @Test

    public void testRemoveToCart(){
        String user = "standard_user";
        String pass = "secret_sauce";
        driver.manage().window().maximize();
        driver.get("http://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        By removeButton = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");
        driver.findElement(removeButton).click();
        Assert.assertTrue(waitForElementToDisappear(removeButton));
        List<WebElement> Items = driver.findElements(By.className("inventory_item_name"));
        System.out.println("Items:" + Items.size());
        java.util.Iterator <WebElement> i = Items.iterator();
        while(i.hasNext()){
            WebElement row = i.next();
            System.out.println(row.getText());
        }
    }

    public boolean waitForElementToDisappear(By element){
        wait = new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            return true;
        }
        catch (Throwable t){
            return false;
        }
    }
}
