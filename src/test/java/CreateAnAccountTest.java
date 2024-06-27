import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
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
        createNewAccountPage = mainPage.tabCreateAnAccount();
        createNewAccountPage.fillingUserInformation(Constants.createAccountEmail,Constants.password);
        myAccountPage = createNewAccountPage.tabCreateAnAccount();

        assertTrue(myAccountPage.isVisibleMessengerSuccessCreateAccount());
    }
    /**
     * Создание аккаунта без параметров
     */
    @DisplayName("Создание аккаунта без параметров")
    @Description("Переход на страницу создания аккаунта, нажатие на копку Sign In")
    @Tag("negative")
    @Test
    public void emptyParameters(){
        createNewAccountPage = mainPage.tabCreateAnAccount();
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.isVisibleMessengerEmptyParameters());
    }
    /**
     * Создание аккаунта с зарегестрированным Email
     */
    @DisplayName("Создание аккаунта с зарегестрированным Email")
    @Description("Переход на страницу создания аккаунта, ввод корректных пользовательских данных, в текстовом поле Email будет содержаться уже ранее зарегестрированная почта, нажатие на копку Create An Account")
    @Tag("negative")
    @Test
    public void registeredEmail(){
        createNewAccountPage = mainPage.tabCreateAnAccount();
        createNewAccountPage.fillingUserInformation(Constants.authorizationEmail,Constants.password);
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.isVisibleMessengerRegisteredEmail());
    }
    /**
     * Создание аккаунта с некорректным Email
     */
    @DisplayName("Создание аккаунта с некоректным Email")
    @Description("Переход на страницу создания аккаунта, ввод корректных пользовательских данных, в текстовом поле Email будет содержаться некорректная почта, нажатие на копку Create An Account")
    @Tag("negative")
    @Test
    public void incorrectEmail(){
        createNewAccountPage = mainPage.tabCreateAnAccount();
        createNewAccountPage.fillingUserInformation(Constants.incorrectEmail,Constants.password);
        createNewAccountPage.tabCreateAnAccount();

        assertTrue(createNewAccountPage.isVisibleMessengerIncorrectEmail());
    }
}
