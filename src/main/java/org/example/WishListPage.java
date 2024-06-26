package org.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;

public class WishListPage extends BasePage{
    /**
     * Удаление товара из избранного
     */
    @Step("Удаление товара из избранного")
    public void tabDeleteProduct(){
        $(By.xpath("//*[@id=\"item_5259\"]/div")).hover();
        $(By.xpath("//a[@data-role=\"remove\"]")).click();
    }
    /**
     * Проверка сообщения об успешном добавлении товара в избранное
     */
    @Step("Проверка появления сообщения об успешном добавлении товара в избранное")
    public boolean visibleMessengerSuccess(){
        return $(By.xpath("//div[@data-ui-id=\"message-success\"]")).shouldBe(visible).isDisplayed();
    }
}
