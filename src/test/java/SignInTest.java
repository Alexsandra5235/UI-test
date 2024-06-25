import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Owner("Alexandra")
@DisplayName("Тесты авторизации")
@ExtendWith(TestListener.class)
public class SignInTest extends BaseTest{
    /**
     * Авторизация с корректными параметрами
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Test
    public void validParameters(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        assertTrue(mainPage.visibleItemPage());
    }
    /**
     * Авторизация без параметров
     */
    @DisplayName("Авторизация без ввода параметров")
    @Description("Переход на страницу авторизации, нажатие на копку Sign In")
    @Test
    public void emptyParameters(){
        mainPage.tabSignIn();

        signInPage.tabSignIn();

        assertTrue(signInPage.visibleMessengerEmptyParameters());
    }
    /**
     * Авторизация с неверным паролем
     */
    @DisplayName("Авторизация с некорректными паролем")
    @Description("Переход на страницу авторизации, ввод пользовательских данных с указанием неверного пароля, нажатие на копку Sign In")
    @Test
    public void invalidPassword(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.invalidPassword);
        signInPage.tabSignIn();

        assertTrue(signInPage.visibleMessengerInvalidPassword());
    }
}
