import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MakingOrderTest extends BaseTest {
    /**
     * Оформление заказа с коректными параметрами
     */
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
