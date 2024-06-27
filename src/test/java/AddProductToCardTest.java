import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты добавления товара в корзину")
@Tag("addToCard")
public class AddProductToCardTest extends BaseTest{
    /**
     * Добавление товара в корзину авторизированным пользователем
     */
    @DisplayName("Добавление товара в корзину авторизированным пользователем")
    @Description("Авторизация пользователя, переход к карточке товара, нажатие на кнопку Add To Card")
    @Tag("positive")
    @Test
    public void authorizationUsers(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        categoryWomenPage = mainPage.tabWomen();
        cardProductPage = categoryWomenPage.tabCardProduct();
        cardProductPage.choiceParametersProduct();
        cardProductPage.tabAddToCard();

        assertTrue(cardProductPage.isVisibleMessengerSuccess());
    }
}
