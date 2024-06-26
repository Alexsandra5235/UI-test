package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class BasePage {
    Constants constants = new Constants();
    //WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
    //SelenideWait waits = new SelenideWait(getWebDriver(),20,20);
}
