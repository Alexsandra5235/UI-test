package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import io.qameta.allure.Step;

import java.security.cert.TrustAnchor;

public class ResultQueryPage extends BasePage{
    /**
     * Проверка совпадения наименований найденных товаров с ключевым словом запроса
     */
    @Step("Проверка совпадения наименований найденных товаров с ключевым словом запроса")
    public boolean containsKeyword(){
        return $$(By.xpath("//ol[@class=\"products list items product-items\"]//a[@class=\"product-item-link\"]")).asFixedIterable().stream().
                allMatch(elem -> elem.getText().contains(constants.searchQuery));
    }
}
