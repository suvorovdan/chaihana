package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DishPage extends BasePage {

    public DishPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return false;
    }





    public void findDish(String dish){
        new WebDriverWait(driver,15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//div[@class = 'product-info']")));
        for(WebElement d:driver.findElements(By.xpath("//li[@class = 'product-item']"))){
            if(d.findElement(By.xpath(".//span[@itemprop='name']")).getText().equals(dish)){

                menuOfDishes.put(d.findElement(By.xpath(".//span[@itemprop='name']")).getText(),
                        d.findElement(By.xpath(".//span[@itemprop='price']")).getText());

                click(d.findElement(By.xpath(".//span[contains(text(),'Заказать')]")));
            }
        }

    }

}
