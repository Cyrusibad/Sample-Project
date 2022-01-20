package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.LgnPage;

public class testLoginPage {

    WebDriver driver;
    LgnPage Login;

    @Given("user is in the login page")
    public void userIsInTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

        driver.manage().window().maximize();
    }

/*    @When("user enters correct username and password")
    public void userEntersCorrectUsernameAndPassword() {
        Login = new LgnPage(driver);
        Login.enterUser("opensourcecms");
        Login.enterPass("opensourcecms");
   }

 */

    @Then("user will be logged in")
    public void userWillBeLoggedIn() {
        Login = new LgnPage(driver);
        Login.clickLogin();
    }

    @When("^user enters correct (.*) and (.*)$")
    public void userEntersCorrectUsernameAndPassword(String arg1, String arg2 ) {
        Login = new LgnPage(driver);
        Login.enterUser(arg1);
        Login.enterPass(arg2);
    }
}
