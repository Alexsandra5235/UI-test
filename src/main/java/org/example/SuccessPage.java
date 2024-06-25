package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessPage extends BasePage{
    /**
     * Проверка наличия элемента на странице
     */
    public boolean visibleItemPage(){
        return $(By.xpath("//h1[@class=\"page-title\"]/span")).shouldBe(visible).isDisplayed();
    }
}
