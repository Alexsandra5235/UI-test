package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;

public class WishListPage {

    public final SelenideElement
            messageSuccess = $x("//div[@data-ui-id=\"message-success\"]");

    /**
     * Проверка сообщения об успешном добавлении товара в избранное
     */
    @Step("Проверка появления сообщения об успешном добавлении товара в избранное")
    public boolean isVisibleMessengerSuccess(){
        return messageSuccess.shouldBe(visible).isDisplayed();
    }
}
