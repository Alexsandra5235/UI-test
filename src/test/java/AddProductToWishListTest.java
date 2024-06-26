import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты добавления товара в корзину")
public class AddProductToWishListTest extends BaseTest{
    /**
     * Добавление товара в избранное авторизированным пользователем
     */
    @DisplayName("Добавление товара в избранное авторизированным пользователем")
    @Description("Авторизация пользователя, переход к карточке товара, нажатие на кнопку Add To Wish List")
    @Tag("positive")
    @Test
    public void authorizationUsers(){
        mainPage.tabSignIn();

        signInPage.fullingEmail(constants.authorizationEmail);
        signInPage.fullingPassword(constants.password);
        signInPage.tabSignIn();

        myAccountPage.tabWomen();

        categoryWomenPage.tabCardProduct();

        cardProductPage.tabAddToWishList();

        assertTrue(wishListPage.visibleMessengerSuccess());

        wishListPage.tabDeleteProduct();
    }
}
