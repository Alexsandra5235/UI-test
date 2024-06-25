import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductTest extends BaseTest{
    /**
     * Поиск товаров по ключевому слову
     */
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
