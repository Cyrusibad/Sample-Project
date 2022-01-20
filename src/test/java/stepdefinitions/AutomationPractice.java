package stepdefinitions;

import io.cucumber.java.cs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.Int32Value;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import test.*;
import test.APAddress;
import test.APCheckPayment;
import test.APDresses;
import test.APHome;
import test.APLoginPage;
import test.APOrderConfirmation;
import test.APPayment;
import test.APSearch;
import test.APShipping;
import test.APSummary;
import test.APTshirts;
import test.DriverSetup;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AutomationPractice extends DriverSetup {

    APLoginPage login;
    APHome home;
    APTshirts tshirts;
    APAddress address;
    APCheckPayment checkPayment;
    APOrderConfirmation orderConfirmation;
    APPayment payment;
    APShipping shipping;
    APSummary summary;
    APDresses dresses;
    APSearch search;

    @Given("User is in the login page of AutomationPractice site")
    public void userIsInTheLoginPageOfAutomationPracticeSite() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println(driver.getTitle());
    }

    @When("^User enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String user,String pass) {
        login = new APLoginPage(driver);
        login.enterUser(user);
        login.enterPass(pass);
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        login = new APLoginPage(driver);
        login.clickLogin();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        Assert.assertEquals("My account - My Store",driver.getTitle());
    }

    @Given("user is in the home page of AutomationPractice site")
    public void userIsInTheHomePageOfAutomationPracticeSite() {
        driver.get("http://www.automationpractice.com");
    }

    @When("user clicks on T-Shirts tab")
    public void userClicksOnTShirtsTab() {
        home = new APHome(driver);
        home.clickTShirts();
    }

    @And("sets the slider for price range")
    public void setsTheSliderForPriceRange() {
        tshirts = new APTshirts(driver);
        tshirts.setSliders(30,-40,0,0);
    }

    @And("clicks the AddToCart Button")
    public void clicksTheAddToCartButton() {
        tshirts = new APTshirts(driver);
        tshirts.addToCart();
    }

    @And("clicks the proceed to checkout button")
    public void clicksTheProceedToCheckoutButton() {
        tshirts = new APTshirts(driver);
        tshirts.clickCheckout();
    }

    @Then("user will be redirected to Orders page")
    public void userWillBeRedirectedToOrdersPage() {
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        System.out.println(driver.getTitle());
    }

    @When("user clicks on proceed to checkout button on order summary page")
    public void userClicksOnProceedToCheckoutButtonOnOrderSummaryPage() {
        summary = new APSummary(driver);
        summary.clickProceedToCheckoutBtn();
    }

    @And("user is in the Address Tab")
    public void userIsInTheAddressTab() {
        address = new APAddress(driver);
        Assert.assertEquals(address.Heading.getText(),"ADDRESSES");
    }

    @And("clicks on proceed to checkout button on Address Page")
    public void clicksOnProceedToCheckoutButtonOnAddressPage() {
        address = new APAddress(driver);
        address.clickProceedToCheckoutBtn();
    }

    @And("ticks the Terms of Service checkbox")
    public void ticksTheTermsOfServiceCheckbox() {
        shipping = new APShipping(driver);
        shipping.clickTermsOfServiceCheckbox();
    }

    @And("clicks the proceed to checkout button on Shipping page")
    public void clicksTheProceedToCheckoutButtonOnShippingPage() {
        shipping = new APShipping(driver);
        shipping.clickProceedToCheckoutBtn();
    }

    @And("selects Pay by check as payment option")
    public void selectsPayByCheckAsPaymentOption() {
        payment = new APPayment(driver);
        payment.clickPayByCheque();
    }

    @And("clicks the I confirm my order button")
    public void clicksTheIConfirmMyOrderButton() {
        checkPayment = new APCheckPayment(driver);
        checkPayment.clickConfirmOrderBtn();
    }

    @Then("order will be complete")
    public void orderWillBeComplete() {
        orderConfirmation = new APOrderConfirmation(driver);
        Assert.assertTrue(orderConfirmation.ConfirmationMessage.isDisplayed());
    }

    @When("user selects Casual Dresses")
    public void userSelectsCasualDresses() {
        home = new APHome(driver);
        home.selectCasualDresses();
    }

    @Then("user is redirected to Casual Dresses subcategory")
    public void userIsRedirectedToCasualDressesSubcategory() {
        dresses = new APDresses(driver);
        Assert.assertTrue(dresses.CDCategoryName.isDisplayed());
    }

    @When("user verifies the total price")
    public void userVerifiesTheTotalPrice() throws ParseException{
        summary = new APSummary(driver);
        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr"));
        Double DoubleValue;
        Double sumValue=2.0;
        DecimalFormat df = new DecimalFormat("00.00");
        String max;
        for(int i=1;i<=rows.size();i++){
            max = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr["+i+"]/td[6]")).getText();
            max = max.replace("$","");
            NumberFormat f = NumberFormat.getNumberInstance();
            Number num = f.parse(max);
            max = num.toString();
            DoubleValue = Double.parseDouble(max);
            sumValue=sumValue+DoubleValue;
        }
        String newValue = df.format(sumValue);
        System.out.println("total:"+"$"+newValue);
        Assert.assertEquals(summary.TotalPrice.getText(),"$"+newValue);
    }

    @Then("total price is correct")
    public void totalPriceIsCorrect() throws ParseException{
        summary = new APSummary(driver);
        AutomationPractice ap = new AutomationPractice();
    }

    @And("user selects Summer Dresses")
    public void userSelectsSummerDresses() {
        home = new APHome(driver);
        home.selectSummerDresses();
    }

    @And("user is redirected to Summer Dresses subcategory")
    public void userIsRedirectedToSummerDressesSubcategory() {
        dresses = new APDresses(driver);
        Assert.assertTrue(dresses.CDCategoryName.isDisplayed());
    }

    @When("^user enters (.*) on search bar$")
    public void userEntersSearchOnSearchBar(String search) {
        home = new APHome(driver);
        home.enterSearchBar(search);
    }

    @Then("results is displayed")
    public void resultsIsDisplayed() {
        search = new APSearch(driver);
        search.verifyResult();
    }
}
