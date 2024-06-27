import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты изменения Email учетной записи пользователя")
@Tag("changeEmail")
public class ChangeEmailTest extends BaseTest{
    /**
     * Изменение Email с корректными параметрами
     */
    @DisplayName("Изменение Email с корректными параметрами")
    @Description("Авторизация пользователя, переход на страницу пользователя в раздел изменения пользовательских данных, ввод данных для изменения Email")
    @Tag("positive")
    @Test
    public void correctParameters(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        mainPage.tabDropDown();
        myAccountPage = mainPage.tabMyAccount();
        accountInformationPage = myAccountPage.tabEdit();
        accountInformationPage.tabChangeEmailCheckBox();
        accountInformationPage.fullingUserDataChangeEmail(Constants.newEmail,Constants.password);
        signInPage = accountInformationPage.tabSave();

        assertTrue(signInPage.isVisibleMessengerSuccessChange());
    }
    @AfterAll
    public static void back(){
        Selenide.open(Constants.url);
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.newEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        mainPage.tabDropDown();
        myAccountPage = mainPage.tabMyAccount();
        accountInformationPage = myAccountPage.tabEdit();
        accountInformationPage.tabChangeEmailCheckBox();
        accountInformationPage.fullingUserDataChangeEmail(Constants.authorizationEmail,Constants.password);
        signInPage = accountInformationPage.tabSave();
    }
}
