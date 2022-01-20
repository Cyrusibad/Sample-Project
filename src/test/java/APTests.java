package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.APHome;
import test.APTshirts;
import test.APLoginPage;
import test.APSummary;
import test.APAddress;
import test.APShipping;
import test.APPayment;
import test.APCheckPayment;
import test.APOrderConfirmation;

import java.util.concurrent.TimeUnit;

public class APTests {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void EndToEnd() {
        int x1 = 30;
        int x2 = -40;
        int y1 = 0;
        int y2 = 0;

        APHome home = new APHome(driver);
        APTshirts tshirts = new APTshirts(driver);
        APLoginPage login = new APLoginPage(driver);
        APSummary summary = new test.APSummary(driver);
        APAddress address = new APAddress(driver);
        APShipping shipping = new APShipping(driver);
        APPayment payment = new APPayment(driver);
        APCheckPayment checkPayment = new APCheckPayment(driver);
        APOrderConfirmation orderConfirmation = new APOrderConfirmation(driver);


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        login.enterUser("cyry123@yahoo.com");
        login.enterPass("123asd");
        login.clickLogin();
        driver.get("http://www.automationpractice.com");
        home.clickTShirts();
        tshirts.setSliders(x1, x2, y1, y2);
        tshirts.addToCart();
        tshirts.clickCheckout();
        summary.clickProceedToCheckoutBtn();
        address.clickProceedToCheckoutBtn();
        shipping.clickTermsOfServiceCheckbox();
        shipping.clickProceedToCheckoutBtn();
        payment.clickPayByCheque();
        checkPayment.clickConfirmOrderBtn();
        Assert.assertTrue(orderConfirmation.ConfirmationMessage.isDisplayed());
    }
}
