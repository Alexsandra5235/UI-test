import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты изменения Password учетной записи пользователя")
@Tag("changePassword")
public class ChangePasswordTest extends BaseTest{
    /**
     * Изменение пароля с неверным параметром "Current Password"
     */
    @Order(1)
    @DisplayName("Изменение Password с неверным параметром Current Password")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения пароля")
    @Tag("negative")
    @Test
    public void invalidCurrentPassword(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        mainPage.tabDropDown();
        myAccountPage = mainPage.tabMyAccount();
        accountInformationPage = myAccountPage.tabEdit();
        accountInformationPage.tabChangePasswordCheckBox();
        accountInformationPage.fullingUserDataChangePassword(Constants.invalidPassword,Constants.invalidPassword);
        signInPage = accountInformationPage.tabSave();

        assertTrue(accountInformationPage.isVisibleMessengerInvalidCurrentPassword());
    }
    /**
     * Изменение пароля с корректными параметрами
     */
    @Order(2)
    @DisplayName("Изменение Password с корректными параметрами")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения пароля")
    @Tag("positive")
    @Test
    public void correctParameters(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        mainPage.tabDropDown();
        myAccountPage = mainPage.tabMyAccount();
        accountInformationPage = myAccountPage.tabEdit();
        accountInformationPage.tabChangePasswordCheckBox();
        accountInformationPage.fullingUserDataChangePassword(Constants.invalidPassword,Constants.password);
        signInPage = accountInformationPage.tabSave();

        assertTrue(signInPage.isVisibleMessengerSuccessChange());
    }
    @AfterAll
    public static void back(){
        Selenide.open(Constants.url);
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.invalidPassword);
        mainPage = signInPage.tabSignIn();
        mainPage.tabDropDown();
        myAccountPage = mainPage.tabMyAccount();
        accountInformationPage = myAccountPage.tabEdit();
        accountInformationPage.tabChangePasswordCheckBox();
        accountInformationPage.fullingUserDataChangePassword(Constants.password,Constants.invalidPassword);
        signInPage = accountInformationPage.tabSave();
    }
}
