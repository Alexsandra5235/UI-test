import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты создания аккаунта")
public class CreateAnAccountTest extends BaseTest{
    /**
     * Создание аккаунта с корректными параметрами
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Disabled
    @Test
    public void validParameters(){
        mainPage.tabCreateAnAccount();

        createNewAccountPage.fillingUserInformation();
        createNewAccountPage.fullingEmail();
        createNewAccountPage.fullingPassword();
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(myAccountPage.visibleMessengerSuccessCreateAccount());
    }

    /**
     * Создание аккаунта без параметров
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Test
    public void emptyParameters(){
        mainPage.tabCreateAnAccount();

        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.visibleMessengerEmptyParameters());
    }
    /**
     * Создание аккаунта с зарегестрированным Email
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Test
    public void registeredEmail(){
        mainPage.tabCreateAnAccount();

        createNewAccountPage.fillingUserInformation();
        createNewAccountPage.fullingRegisteredEmail();
        createNewAccountPage.fullingPassword();
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.visibleMessengerRegisteredEmail());
    }
    /**
     * Создание аккаунта с некоректным Email
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Test
    public void incorrectEmail(){
        mainPage.tabCreateAnAccount();

        createNewAccountPage.fillingUserInformation();
        createNewAccountPage.fullingIncorrectEmail();
        createNewAccountPage.fullingPassword();
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.visibleMessengerIncorrectEmail());
    }
}
