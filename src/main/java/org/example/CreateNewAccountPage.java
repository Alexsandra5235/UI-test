package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import io.qameta.allure.Step;

public class CreateNewAccountPage extends BasePage{
    /**
     * Заполнение информации о пользователе (имя,фамилмя)
     */
    @Step("Заполнение текстовых полей, содержащих информацию о пользователе (имя,фамилмя)")
    public void fillingUserInformation(){
        $(By.xpath("//*[@id=\"firstname\"]")).sendKeys(constants.firstName);
        $(By.xpath("//*[@id=\"lastname\"]")).sendKeys(constants.lastName);
    }

    /**
     * Заполнение почты
     */
    @Step("Заполнение текстового поля Email")
    public void fullingEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.createAccountEmail);
    }
    /**
     * Заполнение зарегестрированной ранее почты
     */
    @Step("Заполнение текстового поля Email, зарегестрированной ранее почтой")
    public void fullingRegisteredEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.authorizationEmail);
    }
    /**
     * Заполнение некорректной почтой
     */
    @Step("Заполнение текстового поля Email, некорректной почтой")
    public void fullingIncorrectEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.incorrectEmail);
    }

    /**
     * Заполнение пароля
     */
    @Step("Заполнение текстового поля Password")
    public void fullingPassword(){
        $(By.xpath("//*[@id=\"password\"]")).sendKeys(constants.password);
        $(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(constants.password);
    }

    /**
     * Нажатие на кнопку "Create An Account"
     */
    @Step("Нажатие на кнопку Create An Account")
    public MyAccountPage tabCreateAnAccount(){
        $$(By.xpath("//div[@class=\"primary\"]/button")).first().click();
        return new MyAccountPage();
    }

    /**
     * Проверка сообщений о незаполненных полях
     * @return
     */
    @Step("Проверка появления сообщений о наличии незаполненных полей")
    public boolean visibleMessengerEmptyParameters(){
        return  $$(By.xpath("//*[@class=\"mage-error\"]")).asFixedIterable().stream().
                allMatch(mess->mess.shouldBe(visible).isDisplayed());
    }
    /**
     * Проверка сообщения о попытке создать аккаунт с рарегестрированным Email
     * @return
     */
    @Step("Проверка появления сообщения о попытке создать аккаунт с рарегестрированным Email")
    public boolean visibleMessengerRegisteredEmail(){
        return $(By.xpath("//div[@data-ui-id=\"message-error\"]")).shouldBe(visible).isDisplayed();
    }

    /**
     * Проверка сообщения о некорректном адресе почты
     * @return
     */
    @Step("Проверка появления сообщения о некорректном адресе электронной почты")
    public boolean visibleMessengerIncorrectEmail(){
        return $(By.xpath("//div[@for=\"email_address\"]")).shouldBe(visible).isDisplayed();
    }
}
