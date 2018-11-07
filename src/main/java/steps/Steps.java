package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.DishPage;
import pages.MainPage;

public class Steps extends BaseSteps {
    MainPage mainPage = new MainPage(driver);
    DishPage dishPage = new DishPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Step("Choose menu section {0}")
    public void chooseMenuSection(String menuSection){
        chooseMenu(menuSection);
    }
    @Step("Choose menu section {0}")
    public void chooseMenu(String food){
        mainPage.openDeliveryMenu();
        mainPage.chooseMenu(food);
    }
    @Step
    public void chooseAndRememberDish(String ... dishes){
        for(String dish:dishes){
            dishPage.findDish(dish);
        }
    }
    @Step("Переход в корзину")
    public void goToCart(){
        dishPage.goToCart();
    }
    @Step("Проверка добавленых блюд")
    public void checkDishes(){
        cartPage.checkDishes();
    }
    @Step("Проверка итоговой суммы")
    public void checkSum(){
        cartPage.checkSum();
    }
    @Step("Удаление всех выбраных блюд")
    public void deleteAllDishes(){
        cartPage.deleteDishes();
    }
    @Step("Проверка пустая ли корзина")
    public void checkCartEmptiness(){
        cartPage.checkCart();
    }
}
