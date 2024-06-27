package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;

public class AccountInformationPage {

    public final SelenideElement
            checkBoxChangeEmail = $x("//*[@id=\"change-email\"]"),
            checkBoxChangePassword = $x("//*[@id=\"change-password\"]"),
            buttonSave = $x("//*[@class=\"action save primary\"]"),
            textBoxNewEmail = $x("//*[@id=\"email\"]"),
            textBoxCurrentPassword = $x("//*[@id=\"current-password\"]"),
            textBoxPassword = $x("//*[@id=\"password\"]"),
            textBoxConfirmNewPassword = $x("//*[@id=\"password-confirmation\"]"),
            messageError = $x("//div[@data-ui-id=\"message-error\"]");

    /**
     * Активация чекбокса "Change Email"
     */
    @Step("Нажатие на чекбокс Change Email для его активации")
    public void tabChangeEmailCheckBox(){

        checkBoxChangeEmail.shouldBe(visible).click();

    }
    /**
     * Активайия чекбокса "Change Password"
     */
    @Step("Нажатие на чекбокс Change Password для его активации")
    public void tabChangePasswordCheckBox(){
        checkBoxChangePassword.shouldBe(visible).click();
    }
    /**
     * Нажатие на кнопку "Save"
     */
    @Step("Нажатие на кнопку Save")
    public SignInPage tabSave(){
        buttonSave.shouldBe(visible).click();
        return new SignInPage();
    }
    /**
     * Заполнение поля "Email" и "Current Password"
     */
    public void fullingUserDataChangeEmail(String email, String currentPassword){
        textBoxNewEmail.shouldBe(visible).clear();
        textBoxNewEmail.sendKeys(email);
        textBoxCurrentPassword.shouldBe(visible).sendKeys(currentPassword);
    }
    /**
     * Заполнение поля "Password","New Password","Confirm New Password"
     */
    @Step("Заполнение полей данными")
    public void fullingUserDataChangePassword(String newPassword, String currentPassword){
        textBoxCurrentPassword.shouldBe(visible).sendKeys(currentPassword);
        textBoxPassword.shouldBe(visible).sendKeys(newPassword);
        textBoxConfirmNewPassword.shouldBe(visible).sendKeys(newPassword);
    }
    /**
     * Проверка сообщения о не совпадении текущего пароля с введенным значением
     */
    @Step("Проверка появления сообщения о не совпадении текущего пароля с введенным пользователм значением")
    public boolean isVisibleMessengerInvalidCurrentPassword(){
        return messageError.shouldBe(visible).isDisplayed();
    }
}
