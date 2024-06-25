package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    /**
     * Нажатие на кнопку "Create An Account"
     */
    public CreateNewAccountPage tabCreateAnAccount(){
        $(By.xpath("//div[@class=\"panel header\"]/ul[@class=\"header links\"]/li[3]/a")).click();
        return new CreateNewAccountPage();
    }
    /**
     * Нажатие на кнопку "Sign In"
     */
    public SignInPage tabSignIn(){
        $$(By.xpath("//ul[@class=\"header links\"]/li/a")).first().click();
        return new SignInPage();
    }
    /**
     * Нажатие на кнопку открытия выпадающего списка перехода между страницами
     */
    public void tabDropDown(){
        $$(By.xpath("//button[@class=\"action switch\"]")).first().click();
    }
    /**
     * Нажатие на кнопку "My Account"
     */
    public MyAccountPage tabMyAccount(){
        $$(By.xpath("//ul[@class=\"header links\"]/li/a")).first().click();
        return new MyAccountPage();
    }
    /**
     * Проверка отображения элемента страницы
     */
    public boolean visibleItemPage(){
        return $(By.xpath("//div[@class=\"sections nav-sections\"]")).shouldBe(visible).isDisplayed();
    }
}