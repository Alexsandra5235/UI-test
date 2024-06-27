import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ScreenshotAttached implements AfterTestExecutionCallback {

    public void afterTestExecution(ExtensionContext context) {
        Boolean isTestFailed = context.getExecutionException().isPresent();

        saveAllureScreenshot();

        if (isTestFailed) {
            saveDom();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/html")
    protected static byte[] saveAllureScreenshot() {
        byte[] screen = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);

        return screen;
    }

    @Attachment(value = "Page screenshot", type = "text/xml")
    protected static String saveDom() {
        return getWebDriver().getPageSource();
    }
}
