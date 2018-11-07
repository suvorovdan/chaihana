package stepdefs;


import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import steps.Steps;

/**
 * Created by student on 05.11.2018.
 */
public class MyStepdefs{
    Steps chaihona = new Steps();
    @Дано("^открыт сайт чайхона$")
    public void openSite() throws Throwable {
    }

    @Когда("^я захожу в корзину$")
    public void яЗахожуВКорзину() throws Throwable {
        chaihona.goToCart();
    }

    @Когда("^я выбираю в меню доставки пункт \"(.*)\"$")
    public void яВыбираюВМенюДоставкиПункт(String arg0) throws Throwable {
        chaihona.chooseMenuSection(arg0);
    }

    @И("^заказываю товары \"(.*)\"$")
    public void заказываюТовары(String arg0) throws Throwable {
        chaihona.chooseAndRememberDish(arg0);
    }


    @Тогда("^я проверяю наличие добавленых товаров$")
    public void яПроверяюНаличиеДобавленыхТоваров() throws Throwable {
        chaihona.checkDishes();
    }

    @И("^проверяю итоговую сумму$")
    public void проверяюИтоговуюСумму() throws Throwable {
        chaihona.checkSum();
    }

    @Когда("^удаляю все товары$")
    public void удаляюВсеТовары() throws Throwable {
        chaihona.deleteAllDishes();
    }

    @Тогда("^проверяю пустая ли корзина$")
    public void проверяюПустаяЛиКорзину() throws Throwable {
        chaihona.checkCartEmptiness();
    }
}
