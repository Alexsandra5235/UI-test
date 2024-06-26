import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты фильтрации товаров")
public class FilteringTest extends BaseTest {
    /**
     * Фильтрация товаров по цвету и размеру
     */
    @DisplayName("Фильтрация товаров по цвету и размеру")
    @Description("Авторизация пользователя, переход в каталог товаров, настройка параметров фильтрации по цвету и размеру")
    @Tag("positive")
    @Test
    public void colorAndSize(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.tabTops();

        categoryTopsPage.choiceSize();
        categoryTopsPage.choiceColor();

        assertTrue(categoryTopsPage.correctFiltering());
    }
    /**
     * Пагинация
     */
    @DisplayName("Пагинация")
    @Description("Авторизация пользователя, переход в каталог товаров, переход на вторую страницу товаров")
    @Tag("positive")
    @Test
    public void Pagination(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.tabTops();

        assertEquals(24,categoryTopsPage.pagination());
    }
}
