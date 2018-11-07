package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 03.11.2018.
 */
public abstract class BasePage {
    public abstract boolean isPageLoaded();


    WebDriver driver;
    Actions actions;
    static HashMap<String,String> menuOfDishes = new HashMap<String, String>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        actions = new Actions(driver);
    }

    public void click(WebElement element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public void scroll(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",element);
    }

    public void scrollViaActions(WebElement element){
        actions.moveToElement(element).perform();
    }

    public WebDriver getDriver() {
        return driver;
    }

    static final String menuPattern = "//a[contains(text(),'%s') and @class]";

    @FindBy(xpath = "//a[contains(text(),'Меню доставки') and @class ='type-global-nav-link-1']")
    WebElement deliveryMenu;

    @FindBy(xpath = "//a[@title = 'Перейти в корзину']")
    WebElement cartButton;

    public void openDeliveryMenu(){
        click(deliveryMenu);
    }

    public void chooseMenu(String food){

        List<WebElement> href= driver.findElements(By.xpath(String.format(menuPattern,food)));
        assertNotEquals("Продукт не найден",0,href.size());
        click(href.get(0));
    }

    public void goToCart(){
        click(cartButton);
    }
}
