package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LgnPage {
    WebDriver driver;

    public LgnPage(WebDriver driver) {
        this.driver = driver;
    }

    By LoginBtn = By.id("wp-submit");
    By UserName = By.id("user_login");
    By Pass = By.id("user_pass");


    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }

    public void enterUser(String user) {
        driver.findElement(UserName).sendKeys(user);
    }

    public void enterPass(String pass) {
        driver.findElement(Pass).sendKeys(pass);
    }


}
