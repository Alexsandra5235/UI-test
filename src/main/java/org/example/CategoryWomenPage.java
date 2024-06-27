package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;

public class CategoryWomenPage {

    public final SelenideElement
            cardProduct = $x("//strong/a[@title=\"Radiant Tee\"]");

    /**
     * Нажатие на карточку товара
     */
    @Step("Нажатие на карточку товара")
    public CardProductPage tabCardProduct(){
        cardProduct.shouldBe(visible).click();
        return new CardProductPage();
    }
}
