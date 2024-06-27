package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage {

    public final SelenideElement
            messageSuccess = $x("//div[@data-ui-id=\"message-success\"]");
    public final ElementsCollection
            editLnk = $$x("//*[@class=\"box box-information\"]//a");

    /**
     * Нажатие на кнопку "Edit"
     */
    @Step("Нажатие на кнопку Edit")
    public AccountInformationPage tabEdit(){
        editLnk.first().shouldBe(visible).click();
        return new AccountInformationPage();
    }
    /**
     * Проверка появления сообщения об успешном создании аккаунта
     * @return
     */
    @Step("Проверка появления сообщения об успешном создании аккаунта")
    public boolean isVisibleMessengerSuccessCreateAccount(){
        return messageSuccess.shouldBe(visible).isDisplayed();
    }
    /**
     * Проверка отображения элементов страницы
     */
    @Step("Проверка отображения элемента на странице My Account")
    public boolean isVisibleItemPage(){
        return editLnk.first().shouldBe(visible).isDisplayed();
    }
}
