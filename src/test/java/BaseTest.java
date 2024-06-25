import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.AccountInformationPage;
import org.example.Constants;
import org.example.MainPage;
import org.example.SignInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {
    Constants constants = new Constants();
    SignInPage signInPage = new SignInPage();
    MainPage mainPage = new MainPage();
    AccountInformationPage accountInformationPage = new AccountInformationPage();

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
