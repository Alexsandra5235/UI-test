import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String screenshotName = "screenshot_" + System.currentTimeMillis();
        Selenide.screenshot(screenshotName);

        // Загрузка скриншота в Allure
        try {
            Path content = Paths.get(screenshotName + ".png");
            Allure.addAttachment("Скриншот после падения теста", "image/png", Files.newInputStream(content), "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void testSuccessful(ExtensionContext context) {
        String screenshotName = "screenshot_" + System.currentTimeMillis();
        Selenide.screenshot(screenshotName);

        // Загрузка скриншота в Allure
        try {
            Path content = Paths.get(screenshotName + ".png");
            Allure.addAttachment("Скриншот после успешного теста", "image/png", Files.newInputStream(content), "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
