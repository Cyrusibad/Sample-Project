package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import test.GoogleHome;

import test.DriverSetup;

import java.util.List;

public class GoogleTest extends DriverSetup {

    GoogleHome home;

    @Given("user is in the home page of Google")
    public void userIsInTheHomePageOfGoogle() {
        driver.get("http://www.google.com");
    }

    @When("^user enters (.*) term$")

    public void userEntersSearchTerm(String search) {
        home = new GoogleHome(driver);
        home.enterSearch(search);
        home.clickSearchButton();
    }

    @Then("related results is displayed")
    public void relatedResultsIsDisplayed() {
        List<WebElement> result = driver.findElements(By.cssSelector("div.yuRUbf"));
        System.out.println("result:\n"+result.get(1).getText());
        driver.close();
    }
}
