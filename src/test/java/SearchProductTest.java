import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты поиска товаров")
@Tag("search")
public class SearchProductTest extends BaseTest{
    /**
     * Поиск товаров по ключевому слову
     */
    @DisplayName("Поиск товаров по ключевому слову")
    @Description("Авторизация пользователя, ввод запроса в поисковую строку")
    @Tag("positive")
    @Test
    public void searchKeyword(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        resultQueryPage = mainPage.fullingSearchQuery();

        assertTrue(resultQueryPage.isContainsKeyword());
    }
}
