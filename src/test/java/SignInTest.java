import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Owner("Alexandra")
@DisplayName("Тесты авторизации")
@Tag("authorization")
public class SignInTest extends BaseTest{
    /**
     * Авторизация с корректными параметрами
     */
    @DisplayName("Авторизация с корректными параметрами")
    @Description("Переход на страницу авторизации, ввод корректных пользовательских данных, нажатие на копку Sign In")
    @Tag("positive")
    @Test
    public void validParameters(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();

        assertTrue(mainPage.isVisibleItemPage());
    }
    /**
     * Авторизация без параметров
     */
    @DisplayName("Авторизация без ввода параметров")
    @Description("Переход на страницу авторизации, нажатие на копку Sign In")
    @Tag("negative")
    @Test
    public void emptyParameters(){
        signInPage = mainPage.tabSignIn();
        signInPage.tabSignIn();

        assertTrue(signInPage.isVisibleMessengerEmptyParameters());
    }
    /**
     * Авторизация с неверным паролем
     */
    @DisplayName("Авторизация с некорректными паролем")
    @Description("Переход на страницу авторизации, ввод пользовательских данных с указанием неверного пароля, нажатие на копку Sign In")
    @Tag("negative")
    @Test
    public void invalidPassword(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.invalidPassword);
        signInPage.tabSignIn();

        assertTrue(signInPage.isVisibleMessengerInvalidPassword());
    }
}
