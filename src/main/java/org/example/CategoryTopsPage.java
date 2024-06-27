package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Stream;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CategoryTopsPage {

    public final SelenideElement
            optionSize = $x("//div[@data-role=\"content\"]//*[@option-id=\"166\"]"),
            optionColor = $x("//div[@data-role=\"content\"]//*[@option-id=\"49\"]"),
            optionDropDownSize = $x("//*[@id=\"narrow-by-list\"]/div[3]"),
            optionDropDownColor = $x("//*[@id=\"narrow-by-list\"]/div[4]");
    public final ElementsCollection
            buttonNextPageProduct = $$x("//div[@class=\"pages\"]//li[@class=\"item pages-item-next\"]/a"),
            listItemProductsSelectedSize = $$x("//li[@class=\"item product product-item\"]//div[@class=\"swatch-attribute size\"]"),
            listItemProductsSelectedColor = $$x("//li[@class=\"item product product-item\"]//div[@class=\"swatch-attribute color\"]"),
            listItemProductsHref = $$x("//li[@class=\"item product product-item\"]//a[@class=\"product photo product-item-photo\"]");
    /**
     * Выбор размера
     */
    @Step("Выбор размера товара")
    public void choiceSize(){
        optionDropDownSize.shouldBe(visible).click();
        optionSize.shouldBe(visible).click();
    }
    /**
     * Выбор цвета
     */
    @Step("Выбор цвета товара")
    public void choiceColor(){
        optionDropDownColor.shouldBe(visible).click();
        optionColor.shouldBe(visible).click();
    }
    /**
     * Нажатие кнопку для перехода на следующую страницу
     */
    @Step("Нажатие кнопку для перехода на следующую страницу товаров")
    public void tabNextPage(){
        buttonNextPageProduct.last().shouldBe(visible).click();
    }
    /**
     * Проверка правильности фильтровки товара
     */
    @Step("Проверка корректности фильтровки товара")
    public boolean isCorrectFiltering(){
        List<String> listSize = listItemProductsSelectedSize
                .asFixedIterable()
                .stream()
                .map(elem->elem.shouldBe(visible).getAttribute("option-selected")).toList();
        List<String> listColor = listItemProductsSelectedColor
                .asFixedIterable()
                .stream()
                .map(elem->elem.shouldBe(visible).getAttribute("option-selected")).toList();

        List<String> list = Stream.concat(listSize.stream(),listColor.stream()).toList();

        return list.stream()
                .allMatch(elem->elem.contains(Constants.optionIdSizeXs) | elem.contains(Constants.optionsIdColorBlack));
    }
    /**
     * Проверка пагинации сайта
     */
    @Step("Проверка пагинации на сайте")
    public boolean isCheckPagination(){
        List<String> listOnePage = listItemProductsHref
                .asFixedIterable()
                .stream()
                .map(elem->elem.shouldBe(visible).getAttribute("href")).toList();
        tabNextPage();
        List<String> listTwoPage = listItemProductsHref
                .asFixedIterable()
                .stream()
                .map(elem->elem.shouldBe(visible).getAttribute("href")).toList();

        List<String> list = Stream.concat(listOnePage.stream(),listTwoPage.stream()).toList();

        int uniqueValues = list.stream().distinct().toList().size();

        if (uniqueValues == listOnePage.size() + listTwoPage.size()){
            return true;
        }
        else {
            return false;
        }
    }
}
