import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты фильтрации товаров")
@Tag("filter")
public class FilteringTest extends BaseTest {
    /**
     * Фильтрация товаров по цвету и размеру
     */
    @DisplayName("Фильтрация товаров по цвету и размеру")
    @Description("Авторизация пользователя, переход в каталог товаров, настройка параметров фильтрации по цвету и размеру")
    @Tag("positive")
    @Test
    public void colorAndSize(){
        signInPage = mainPage.tabSignIn();

        signInPage.fullingEmailAndPassword(Constants.authorizationEmail, Constants.password);
        mainPage = signInPage.tabSignIn();
        categoryTopsPage = mainPage.tabTops();
        categoryTopsPage.choiceSize();
        categoryTopsPage.choiceColor();

        assertTrue(categoryTopsPage.isCorrectFiltering());
    }
    /**
     * Пагинация
     */
    @DisplayName("Пагинация")
    @Description("Авторизация пользователя, переход в каталог товаров, переход на вторую страницу товаров")
    @Tag("positive")
    @Test
    public void Pagination(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail, Constants.password);
        mainPage = signInPage.tabSignIn();
        categoryTopsPage = mainPage.tabTops();

        assertTrue(categoryTopsPage.isCheckPagination());
    }
}
