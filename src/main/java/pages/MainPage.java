package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 03.11.2018.
 */
public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
        killWindow();
    }

    public boolean isPageLoaded() {
        return false;
    }

    public void killWindow(){
        new WebDriverWait(driver,15)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//div[contains(text(),'Спасибо, но нет')]")));
        List<WebElement> notification = driver.findElements(By.xpath("//div[contains(text(),'Спасибо, но нет')]"));
        if(notification.size()!= 0){
            click(notification.get(0));
        }
    }






}
