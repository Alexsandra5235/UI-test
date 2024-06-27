package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import io.qameta.allure.Step;

public class SuccessPage {

    public final SelenideElement
            itemPage = $x("//h1[@class=\"page-title\"]/span");

    /**
     * Проверка наличия элемента на странице
     */
    @Step("Проверка наличия элемента на странице")
    public boolean isVisibleItemPage(){
        return itemPage.shouldBe(visible).isDisplayed();
    }
}
