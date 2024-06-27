import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты добавления товара в избранное")
@Tag("addToWishList")
public class AddProductToWishListTest extends BaseTest{
    /**
     * Добавление товара в избранное авторизированным пользователем
     */
    @DisplayName("Добавление товара в избранное авторизированным пользователем")
    @Description("Авторизация пользователя, переход к карточке товара, нажатие на кнопку Add To Wish List")
    @Tag("positive")
    @Test
    public void authorizationUsers(){
        signInPage = mainPage.tabSignIn();
        signInPage.fullingEmailAndPassword(Constants.authorizationEmail,Constants.password);
        mainPage = signInPage.tabSignIn();
        categoryWomenPage = mainPage.tabWomen();
        cardProductPage = categoryWomenPage.tabCardProduct();
        wishListPage = cardProductPage.tabAddToWishList();

        assertTrue(wishListPage.isVisibleMessengerSuccess());

    }
}
