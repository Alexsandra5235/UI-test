import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenshotAttached.class)
abstract public class BaseTest {
    static MainPage mainPage = new MainPage();
    static AccountInformationPage accountInformationPage;
    static MyAccountPage myAccountPage;
    static CardProductPage cardProductPage;
    static CategoryTopsPage categoryTopsPage;
    static CategoryWomenPage categoryWomenPage;
    static WishListPage wishListPage;
    static CreateNewAccountPage createNewAccountPage;
    static CheckoutPage checkoutPage;
    static SuccessPage successPage;
    static ResultQueryPage resultQueryPage;
    static SignInPage signInPage;

    public void SetUp(){
        Configuration.browser = "edge";
    }

    @BeforeEach
    public void Init(){
        SetUp();
        Selenide.open(Constants.url);
    }

    @AfterEach()
    public void TernDown(){
        Selenide.closeWebDriver();
    }
}
