package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.DriverSetup;
import test.PhpTravelsHome;
import test.PhpTravelsLogin;

public class PhpTravels extends DriverSetup {

    PhpTravelsHome home;
    PhpTravelsLogin login;

    @Given("User is in the home page of PhpTravels")
    public void userIsInTheHomePageOfPhpTravels() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver.get("http://www.phptravels.net");
    }

    @When("^User enters (.*) to the SearchByCity textbox$")
    public void userEntersCityToTheSearchByCityTextbox(String city){
        home = new PhpTravelsHome(driver);
        home.enterSearchByCity(city);
    }

    @Given("User is in the login page of PhpTravels")
    public void userIsInTheLoginPageOfPhpTravels() {
        login = new PhpTravelsLogin(driver);
        driver.get("http://www.phptravels.net/login");
    }

    @When("User enters the following details")
    public void userEntersTheFollowingDetails() {
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        login = new PhpTravelsLogin(driver);
        login.clickLoginBtn();
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
    }

    @When("User enters username, password")
    public void userEntersUsernamePassword() {
        login = new PhpTravelsLogin(driver);
        login.enterEmail("user@phptravels.com");
        login.enterPass("demouser");
    }

    @And("User enters the date for Checkin")
    public void userEntersTheDateForCheckin() {
        home = new PhpTravelsHome(driver);
        home.SetCheckinDate("14");
    }

    @And("User enters the date for Checkout")
    public void userEntersTheDateForCheckout() {
    }

    @And("User clicks the Search button")
    public void userClicksTheSearchButton() {
    }
}
