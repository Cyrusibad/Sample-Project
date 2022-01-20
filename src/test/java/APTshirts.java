package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APTshirts {

    WebDriver driver;
    Actions action;

    public APTshirts(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    @FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[1]")
    WebElement Slider1;
    @FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[2]")
    WebElement Slider2;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    WebElement ItemThumbnail;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
    WebElement AddToCartBtn;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement ProceedToCheckoutBtn;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
    WebElement SMsg;

    public void setSliders(int x1, int x2, int y1, int y2) {
        action.clickAndHold(Slider1).moveByOffset(x1, y1).release().perform();
        action.clickAndHold(Slider2).moveByOffset(x2, y2).release().perform();
    }

    public void addToCart() {
        action.moveToElement(ItemThumbnail);
        action.moveToElement(AddToCartBtn);
        action.click().build().perform();
    }

    public void clickCheckout() {
        action.moveToElement(SMsg).perform();
        ProceedToCheckoutBtn.click();
    }
}
