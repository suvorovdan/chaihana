import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.BaseSteps;
import steps.Steps;

/**
 * Created by user on 03.11.2018.
 */
public class ChaihanaTest {


    @Before
    public void start(){
        BaseSteps.startUp();
    }

    @After
    public void end(){
        BaseSteps.tearDown();
    }

    @Test
    public void myTest(){
        Steps chaihona = new Steps();
        chaihona.chooseMenuSection("Шаурма");
        chaihona.chooseAndRememberDish("Шаурма с курицей","Бифбургер с белыми грибами и трюфельным кремом");
        chaihona.chooseMenu("Плов");
        chaihona.chooseAndRememberDish("Плов Чайханский");
        chaihona.goToCart();
        chaihona.checkDishes();
        chaihona.checkSum();
        chaihona.deleteAllDishes();
        chaihona.checkCartEmptiness();
    }
}
