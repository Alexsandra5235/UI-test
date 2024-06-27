package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.Step;

public class SignInPage {

    public final SelenideElement
            textBoxEmail = $x("//*[@id=\"email\"]"),
            textBoxPassword = $x("//*[@id=\"pass\"]"),
            buttonSignIn = $x("//*[@id=\"send2\"]"),
            messageError = $x("//div[@data-ui-id=\"message-error\"]"),
            messageSuccess = $x("//div[@data-ui-id=\"message-success\"]");
    public final ElementsCollection
            messageEmptyTextBoxError = $$x("//*[@class=\"mage-error\"]");

    /**
     * Заполнение почты и пароля
     */
    @Step("Заполнение текстового поля Email и Password")
    public void fullingEmailAndPassword(String email, String password){
        textBoxEmail.shouldBe(visible).sendKeys(email);
        textBoxPassword.shouldBe(visible).sendKeys(password);
    }
    /**
     * Нажатие на кнопку "Sign In"
     */
    @Step("Нажатие на кнопку Sign In")
    public MainPage tabSignIn(){
        buttonSignIn.shouldBe(visible).click();
        return new MainPage();
    }
    /**
     * Проверка сообщения о необходимости заполнить поля
     */
    @Step("Проверка отображения сообщения о необходимости заполнить поля")
    public boolean isVisibleMessengerEmptyParameters(){
        return messageEmptyTextBoxError.asFixedIterable().stream().
                allMatch(mess->mess.shouldBe(visible).isDisplayed());
    }
    /**
     * Проверка сообщения о неверно указаном пароле
     */
    @Step("Проверка отображения сообщения о неверно указаном пароле")
    public boolean isVisibleMessengerInvalidPassword(){
        return messageError.shouldBe(visible).isDisplayed();
    }
    /**
     * Проверка сообщения об успешном изменении почты или пароля
     */
    @Step("Проверка появления сообщения об успешно измененных данных")
    public boolean isVisibleMessengerSuccessChange(){
        return messageSuccess.shouldBe(visible).isDisplayed();
    }
}
