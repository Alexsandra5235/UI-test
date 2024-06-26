import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePasswordTest extends BaseTest{
    /**
     * Изменение пароля с корректными параметрами
     */
    @DisplayName("Изменение Email с корректными параметрами")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения пароля")
    @Tag("positive")
    @Test
    public void correctParameters(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        mainPage.tabDropDown();
        mainPage.tabMyAccount();

        myAccountPage.tabEdit();

        accountInformationPage.tabCheckBoxChangePassword();
        accountInformationPage.fullingNewPassword(constants.invalidPassword);
        accountInformationPage.fullingCurrentPassword(constants.password);
        accountInformationPage.tabSave();

        assertTrue(signInPage.visibleMessengerSuccessChange());

        //Меняем пароль обратно
        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.invalidPassword);
        signInPage.tabSignIn();

        mainPage.tabDropDown();
        mainPage.tabMyAccount();

        myAccountPage.tabEdit();

        accountInformationPage.tabCheckBoxChangePassword();
        accountInformationPage.fullingNewPassword(constants.password);
        accountInformationPage.fullingCurrentPassword(constants.invalidPassword);
        accountInformationPage.tabSave();

    }
    /**
     * Изменение пароля с неверным параметром "Current Password"
     */
    @DisplayName("Изменение Email с неверным параметром Current Password")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения пароля")
    @Tag("negative")
    @Test
    public void invalidCurrentPassword(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        mainPage.tabDropDown();
        mainPage.tabMyAccount();

        myAccountPage.tabEdit();

        accountInformationPage.tabCheckBoxChangePassword();
        accountInformationPage.fullingNewPassword(constants.invalidPassword);
        accountInformationPage.fullingCurrentPassword(constants.invalidPassword);
        accountInformationPage.tabSave();

        assertTrue(accountInformationPage.visibleMessengerInvalidCurrentPassword());
    }
}
