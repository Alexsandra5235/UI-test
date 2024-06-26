import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты создания аккаунта")
@Tag("createAccount")
public class CreateAnAccountTest extends BaseTest{
    /**
     * Создание аккаунта с корректными параметрами
     */
    @DisplayName("Создание аккаунта с корректными параметрами")
    @Description("Переход на страницу создания аккаунта, ввод корректных пользовательских данных, нажатие на копку Create An Account")
    @Disabled
    @Tag("positive")
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
    @DisplayName("Создание аккаунта без параметров")
    @Description("Переход на страницу создания аккаунта, нажатие на копку Sign In")
    @Tag("negative")
    @Test
    public void emptyParameters(){
        mainPage.tabCreateAnAccount();

        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.visibleMessengerEmptyParameters());
    }
    /**
     * Создание аккаунта с зарегестрированным Email
     */
    @DisplayName("Создание аккаунта с зарегестрированным Email")
    @Description("Переход на страницу создания аккаунта, ввод корректных пользовательских данных, в текстовом поле Email будет содержаться уже ранее зарегестрированная почта, нажатие на копку Create An Account")
    @Tag("negative")
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
     * Создание аккаунта с некорректным Email
     */
    @DisplayName("Создание аккаунта с некоректным Email")
    @Description("Переход на страницу создания аккаунта, ввод корректных пользовательских данных, в текстовом поле Email будет содержаться некорректная почта, нажатие на копку Create An Account")
    @Tag("negative")
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
