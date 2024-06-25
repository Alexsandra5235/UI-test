package org.example;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryTopsPage extends BasePage{
    /**
     * Выбор размера
     */
    public void choiceSize(){
        $(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]")).click();
        $(By.xpath("//div[@data-role=\"content\"]//*[@option-id=\"166\"]")).click();
    }
    /**
     * Выбор цвета
     */
    public void choiceColor(){
        $(By.xpath("//*[@id=\"narrow-by-list\"]/div[4]")).click();
        $(By.xpath("//div[@data-role=\"content\"]//*[@option-id=\"49\"]")).click();
    }
    /**
     * Нажатие кнопки для перехода на другую страницу
     */
    public void tabNextPage(){
        $$(By.xpath("//div[@class=\"pages\"]//li[@class=\"item pages-item-next\"]/a")).last().click();
    }
    /**
     * Проверка правильности фильтровки товара
     */
    public boolean correctFiltering(){
        List<String> listSize = $$(By.xpath("//li[@class=\"item product product-item\"]//div[@class=\"swatch-attribute size\"]"))
                .asFixedIterable().stream().map(elem->elem.getAttribute("option-selected")).toList();

        List<String> listColor = $$(By.xpath("//li[@class=\"item product product-item\"]//div[@class=\"swatch-attribute color\"]"))
                .asFixedIterable().stream().map(elem->elem.getAttribute("option-selected")).toList();

        List<String> list = Stream.concat(listSize.stream(),listColor.stream()).collect(Collectors.toList());

        return list.stream().allMatch(elem->elem.contains(constants.optionIdSizeXs) | elem.contains(constants.optionsIdColorBlack));
    }
    /**
     * Проверка пагинации сайта
     */
    public int pagination(){
        List<String> listOnePage = $$(By.xpath("//li[@class=\"item product product-item\"]//a[@class=\"product photo product-item-photo\"]"))
                .asFixedIterable().stream().map(elem->elem.getAttribute("href")).toList();
        tabNextPage();
        List<String> listTwoPage = $$(By.xpath("//li[@class=\"item product product-item\"]//a[@class=\"product photo product-item-photo\"]"))
                .asFixedIterable().stream().map(elem->elem.getAttribute("href")).toList();
        List<String> list = Stream.concat(listOnePage.stream(),listTwoPage.stream()).collect(Collectors.toList());
        int uniqueValues = list.stream().distinct().collect(Collectors.toList()).size();
        return uniqueValues;

    }
}
