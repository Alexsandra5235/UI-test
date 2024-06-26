import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты оформления заказа")
@Tag("makingOrder")
public class MakingOrderTest extends BaseTest {
    /**
     * Оформление заказа с коректными параметрами
     */
    @DisplayName("Оформление заказа с коректными параметрами")
    @Description("Авторизация пользователя, переход в каталог товаров, добавление товара в корзину, выбор адресса доставки, оформление заказа")
    @Tag("positive")
    @Test
    public void correctParameters(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.tabWomen();

        categoryWomenPage.tabCardProduct();

        cardProductPage.choiceParametersProduct();
        cardProductPage.tabAddToCard();
        cardProductPage.tabCard();
        cardProductPage.tabProceedToCheckout();

        checkoutPage.tabNext();
        checkoutPage.tabPlaceOrder();

        assertTrue(successPage.visibleItemPage());
    }
}
