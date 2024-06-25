package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountInformationPage extends BasePage{
    /**
     * Активация чекбокса "Change Email"
     */
    public void tabCheckBoxChangeEmail(){
        $(By.xpath("//*[@id=\"change-email\"]")).click();
    }
    /**
     * Активайия чекбокса "Change Password"
     */
    public void tabCheckBoxChangePassword(){
        $(By.xpath("//*[@id=\"change-password\"]")).click();
    }

    /**
     * Нажатие на кнопку "Save"
     */
    public SignInPage tabSave(){
        $(By.xpath("//*[@class=\"action save primary\"]")).click();
        return new SignInPage();
    }
    /**
     * Заполнение поля "Email"
     */
    public void fullingNewEmail(String email){
        $(By.xpath("//*[@id=\"email\"]")).clear();
        $(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
    }
    /**
     * Заполнение поля "Current Password"
     */
    public void fullingCurrentPassword(String currentPassword){
        $(By.xpath("//*[@id=\"current-password\"]")).sendKeys(currentPassword);
    }
    /**
     * Заполнение поля "New Password" и "ConfirmNewPassword"
     */
    public void fullingNewPassword(String newPassword){
        $(By.xpath("//*[@id=\"password\"]")).sendKeys(newPassword);
        $(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(newPassword);
    }
    /**
     * Проверка сообщения о не совпадении текущего пароля с введенным значением
     */
    public boolean visibleMessengerInvalidCurrentPassword(){
        return $(By.xpath("//div[@data-ui-id=\"message-error\"]")).shouldBe(visible).isDisplayed();
    }
}
