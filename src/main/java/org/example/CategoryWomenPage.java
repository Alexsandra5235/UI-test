package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;

public class CategoryWomenPage extends BasePage{
    /**
     * Нажатие на карточку товара
     */
    @Step("Нажатие на карточку товара")
    public CardProductPage tabCardProduct(){
        $(By.xpath("//strong/a[@title=\"Radiant Tee\"]")).click();
        return new CardProductPage();
    }
}
