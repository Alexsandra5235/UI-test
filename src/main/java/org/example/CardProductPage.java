package org.example;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CardProductPage extends BasePage{
    /**
     * Выбор размера и цвета товара
     */
    @Step("Выбор размера и цвета товара")
    public void choiceParametersProduct(){
        $(By.xpath("//*[@id=\"option-label-size-143-item-166\"]")).click();
        $(By.xpath("//*[@id=\"option-label-color-93-item-50\"]")).click();
    }

    /**
     * Нажатие на кнопку "Add To Card"
     */
    @Step("Нажатие на кнопку Add To Card")
    public void tabAddToCard(){
        $(By.xpath("//*[@id=\"product-addtocart-button\"]")).shouldBe(visible).click();
        Selenide.sleep(5000);
    }
    /**
     * Нажатие на логотип корзины
     */
    @Step("Нажатие на логотип корзины в верхнем правом углу страницы")
    public void tabCard(){
        $(By.xpath("//div[@data-block=\"minicart\"]")).shouldBe(visible).click();
    }
    /**
     * Удаление товара из корзины
     */
    @Step("Удаление товара из корзины")
    public void tabDeleteProduct(){
        $$(By.xpath("//div[@class=\"secondary\"]/a")).first().click();
        $(By.xpath("//footer[@class=\"modal-footer\"]/button[2]")).click();
    }

    /**
     * Добавление товара в избранное
     */
    @Step("Нажатие на кнопку Add To Wish List")
    public WishListPage tabAddToWishList(){
        $(By.xpath("//div[@data-role=\"add-to-links\"]/a[1]")).click();
        return new WishListPage();
    }
    /**
     * Нажатие на кнопку "Proceed To Checkout"
     */
    @Step("Нажатие на кнопку Proceed To Checkout")
    public CheckoutPage tabProceedToCheckout(){
//        wait.until(ExpectedConditions.elementToBeClickable
//                (By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
//        waits.until(ExpectedConditions.elementToBeClickable
//                (By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
        $(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).shouldBe(visible).click();
        return new CheckoutPage();
    }
    /**
     * Проверка сообщения об успешном добавлении товара в корзину
     */
    @Step("Проверка появления сообщения об успешном добавлении товара в корзину")
    public boolean visibleMessengerSuccess(){
        return $(By.xpath("//div[@data-ui-id=\"message-success\"]")).shouldBe(visible).isDisplayed();
    }
}
