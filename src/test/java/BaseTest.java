import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(ScreenshotAttached.class)
abstract public class BaseTest {
    Constants constants = new Constants();
    SignInPage signInPage = new SignInPage();
    MainPage mainPage = new MainPage();
    AccountInformationPage accountInformationPage = new AccountInformationPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CardProductPage cardProductPage = new CardProductPage();
    CategoryTopsPage categoryTopsPage = new CategoryTopsPage();
    CategoryWomenPage categoryWomenPage = new CategoryWomenPage();
    WishListPage wishListPage = new WishListPage();
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    SuccessPage successPage = new SuccessPage();
    ResultQueryPage resultQueryPage = new ResultQueryPage();

    public void SetUp(){
        Configuration.browser = "edge";
        Configuration.headless = false;
    }

    @BeforeEach
    public void Init(){
        SetUp();
        Selenide.open(constants.url);
    }

    @AfterEach()
    public void TernDown(){
        Selenide.closeWebDriver();
    }
}
