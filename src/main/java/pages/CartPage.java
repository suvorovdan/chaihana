package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return false;
    }

    @FindBy(id = "cartPrice")
    WebElement cartPrice;

    @Step
    public void checkDishes(){
        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@class = 'cart-item']"));
        Assert.assertNotEquals("Товары не были добавлены",0,cartItems.size());
        for (WebElement dish:cartItems){

            String dishName = dish.findElement(By.xpath("./td[@class='product-name']/a[contains(@href,'product')]")).getText();
            Assert.assertEquals("Не найдено блюдо: " + dishName,true,menuOfDishes.containsKey(dishName));
        }

    }
    @Step
    public void checkSum(){
        int sum = 0;
        for (String cost:menuOfDishes.values()){

            sum += Integer.parseInt(cost.replace(" \u20BD",""));
        }
        Assert.assertEquals("",sum,Integer.parseInt(cartPrice.getText()));
    }
    @Step
    public void deleteDishes(){
        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@class = 'cart-item']"));
        for (WebElement dish:cartItems){
            click(dish.findElement(By.xpath(".//span[contains(text(),'Удалить')]")));
        }
    }
    @Step
    public void checkCart(){
        Assert.assertEquals("","Ваша корзина пуста",driver.findElement(By.xpath("//h2")).getText());
    }

}
