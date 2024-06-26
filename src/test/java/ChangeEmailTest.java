import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты изменения Email учетной записи пользователя")
public class ChangeEmailTest extends BaseTest{
    /**
     * Изменение Email с корректными параметрами
     */
    @DisplayName("Изменение Email с корректными параметрами")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения Email")
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

        accountInformationPage.tabCheckBoxChangeEmail();
        accountInformationPage.fullingNewEmail(constants.newEmail);
        accountInformationPage.fullingCurrentPassword(constants.password);
        accountInformationPage.tabSave();

        assertTrue(signInPage.visibleMessengerSuccessChange());

        //Меняем почту обратно
        signInPage.fullingEmail(constants.newEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        mainPage.tabDropDown();
        mainPage.tabMyAccount();

        myAccountPage.tabEdit();

        accountInformationPage.tabCheckBoxChangeEmail();
        accountInformationPage.fullingNewEmail(constants.authorizationEmail);
        accountInformationPage.fullingCurrentPassword(constants.password);
        accountInformationPage.tabSave();
    }
}
