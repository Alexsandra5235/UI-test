package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    /**
     * Нажатие на кнопку "Create An Account"
     */
    @Step("Нажатие на кнопку Create An Account")
    public CreateNewAccountPage tabCreateAnAccount(){
        $(By.xpath("//div[@class=\"panel header\"]/ul[@class=\"header links\"]/li[3]/a")).click();
        return new CreateNewAccountPage();
    }
    /**
     * Нажатие на кнопку "Sign In"
     */
    @Step("Нажатие на ссылку Sign In в верхней правой части сайта")
    public SignInPage tabSignIn(){
        $$(By.xpath("//ul[@class=\"header links\"]/li/a")).first().click();
        return new SignInPage();
    }
    /**
     * Нажатие на кнопку открытия выпадающего списка перехода между страницами
     */
    @Step("Нажатие на выпадающий список перехода между страницами")
    public void tabDropDown(){
        $$(By.xpath("//button[@class=\"action switch\"]")).first().click();
    }
    /**
     * Нажатие на кнопку "My Account"
     */
    @Step("Нажатие в выпадающем списке на кнопку My Account")
    public MyAccountPage tabMyAccount(){
        $$(By.xpath("//ul[@class=\"header links\"]/li/a")).first().click();
        return new MyAccountPage();
    }
    /**
     * Проверка отображения элемента страницы
     */
    @Step("Проверка отображения элемента на главной странице сайта")
    public boolean visibleItemPage(){
        return $(By.xpath("//div[@class=\"sections nav-sections\"]")).shouldBe(visible).isDisplayed();
    }
}