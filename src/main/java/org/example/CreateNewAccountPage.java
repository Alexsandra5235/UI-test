package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.Step;

public class CreateNewAccountPage {

    public final SelenideElement
            textBoxFirstName = $x("//*[@id=\"firstname\"]"),
            textBoxLastName = $x("//*[@id=\"lastname\"]"),
            textBoxEmail = $x("//*[@id=\"email_address\"]"),
            textBoxPassword = $x("//*[@id=\"password\"]"),
            textBoxConfirmPassword = $x("//*[@id=\"password-confirmation\"]"),
            messageError = $x("//div[@data-ui-id=\"message-error\"]"),
            messageIncorrectEmail = $x("//div[@for=\"email_address\"]");
    public final ElementsCollection
            buttonCreateAnAccount = $$x("//div[@class=\"primary\"]/button"),
            messageEmptyTextBoxError = $$x("//*[@class=\"mage-error\"]");

    /**
     * Заполнение информации о пользователе
     */
    @Step("Заполнение текстовых полей пользовательской информацией")
    public void fillingUserInformation(String email,String password){
        textBoxFirstName.shouldBe(visible).sendKeys(Constants.firstName);
        textBoxLastName.shouldBe(visible).sendKeys(Constants.lastName);
        textBoxEmail.shouldBe(visible).sendKeys(email);
        textBoxPassword.shouldBe(visible).sendKeys(password);
        textBoxConfirmPassword.shouldBe(visible).sendKeys(password);
    }
    /**
     * Нажатие на кнопку "Create An Account"
     */
    @Step("Нажатие на кнопку Create An Account")
    public MyAccountPage tabCreateAnAccount(){
        buttonCreateAnAccount.first().shouldBe(visible).click();
        return new MyAccountPage();
    }
    /**
     * Проверка сообщений о незаполненных полях
     * @return
     */
    @Step("Проверка появления сообщений о наличии незаполненных полей")
    public boolean isVisibleMessengerEmptyParameters(){
        return  messageEmptyTextBoxError.asFixedIterable().stream().
                allMatch(mess->mess.shouldBe(visible).isDisplayed());
    }
    /**
     * Проверка сообщения о попытке создать аккаунт с рарегестрированным Email
     * @return
     */
    @Step("Проверка появления сообщения о попытке создать аккаунт с рарегестрированным Email")
    public boolean isVisibleMessengerRegisteredEmail(){
        return messageError.shouldBe(visible).isDisplayed();
    }
    /**
     * Проверка сообщения о некорректном адресе почты
     * @return
     */
    @Step("Проверка появления сообщения о некорректном адресе электронной почты")
    public boolean isVisibleMessengerIncorrectEmail(){
        return messageIncorrectEmail.shouldBe(visible).isDisplayed();
    }
}
