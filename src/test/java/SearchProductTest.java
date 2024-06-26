import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты поиска товаров")
public class SearchProductTest extends BaseTest{
    /**
     * Поиск товаров по ключевому слову
     */
    @DisplayName("Поиск товаров по ключевому слову")
    @Description("Авторизация пользователя, ввод запроса в поисковую строку")
    @Tag("positive")
    @Test
    public void searchKeyword(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.fullingSearchQuery();

        assertTrue(resultQueryPage.containsKeyword());
    }
}
