import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты добавления товара в корзину")
public class AddProductToCardTest extends BaseTest{
    /**
     * Добавление товара в корзину авторизированным пользователем
     */
    @DisplayName("Добавление товара в корзину авторизированным пользователем")
    @Description("Авторизация пользователя, переход к карточке товара, нажатие на кнопку Add To Card")
    @Test
    public void authorizationUsers(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.tabWomen();

        categoryWomenPage.tabCardProduct();

        cardProductPage.choiceParametersProduct();
        cardProductPage.tabAddToCard();

        assertTrue(cardProductPage.visibleMessengerSuccess());

        cardProductPage.tabCard();
        cardProductPage.tabDeleteProduct();
    }
}
