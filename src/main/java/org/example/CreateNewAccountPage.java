package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateNewAccountPage extends BasePage{
    /**
     * Заполнение информации о пользователе (имя,фамилмя)
     */
    public void fillingUserInformation(){
        $(By.xpath("//*[@id=\"firstname\"]")).sendKeys(constants.firstName);
        $(By.xpath("//*[@id=\"lastname\"]")).sendKeys(constants.lastName);
    }

    /**
     * Заполнение почты
     */
    public void fullingEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.createAccountEmail);
    }
    /**
     * Заполнение зарегестрированной ранее почты
     */
    public void fullingRegisteredEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.authorizationEmail);
    }
    /**
     * Заполнение некорректной почтой
     */
    public void fullingIncorrectEmail(){
        $(By.xpath("//*[@id=\"email_address\"]")).sendKeys(constants.incorrectEmail);
    }

    /**
     * Заполнение паррля
     */
    public void fullingPassword(){
        $(By.xpath("//*[@id=\"password\"]")).sendKeys(constants.password);
        $(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(constants.password);
    }

    /**
     * Нажатие на кнопку "Create An Account"
     */
    public MyAccountPage tabCreateAnAccount(){
        $$(By.xpath("//div[@class=\"primary\"]/button")).first().click();
        return new MyAccountPage();
    }

    /**
     * Проверка сообщений о незаполненных полях
     * @return
     */
    public boolean visibleMessengerEmptyParameters(){
        return  $$(By.xpath("//*[@class=\"mage-error\"]")).asFixedIterable().stream().
                allMatch(mess->mess.shouldBe(visible).isDisplayed());
    }
    /**
     * Проверка сообщения о попытке создать аккаунт с рарегестрированным Email
     * @return
     */
    public boolean visibleMessengerRegisteredEmail(){
        return $(By.xpath("//div[@data-ui-id=\"message-error\"]")).shouldBe(visible).isDisplayed();
    }

    /**
     * Проверка сообщения о некорректном адресе почты
     * @return
     */
    public boolean visibleMessengerIncorrectEmail(){
        return $(By.xpath("//div[@for=\"email_address\"]")).shouldBe(visible).isDisplayed();
    }
}
