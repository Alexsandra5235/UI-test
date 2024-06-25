package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class ResultQueryPage extends BasePage{
    /**
     * Проверка совпадения наименований найденных товаров с ключевым словом запроса
     */
    public boolean containsKeyword(){
        return $$(By.xpath("//a[@class=\"product-item-link\"]")).asFixedIterable().stream().
                allMatch(elem -> elem.getText().contains(constants.searchQuery));
    }
}
