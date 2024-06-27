package org.example;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ResultQueryPage {

    public final ElementsCollection
            products = $$x("//ol[@class=\"products list items product-items\"]//a[@class=\"product-item-link\"]");

    /**
     * Проверка совпадения наименований найденных товаров с ключевым словом запроса
     */
    @Step("Проверка совпадения наименований найденных товаров с ключевым словом запроса")
    public boolean isContainsKeyword(){
        return products.asFixedIterable().stream().
                allMatch(elem -> elem.shouldBe(visible).getText().contains(Constants.searchQuery));
    }
}
