package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardProductPage {

    public final SelenideElement
            optionSize = $x("//*[@id=\"option-label-size-143-item-166\"]"),
            optionColor = $x("//*[@id=\"option-label-color-93-item-50\"]"),
            buttonAddToCard = $x("//*[@id=\"product-addtocart-button\"]"),
            iconCard = $x("//div[@data-block=\"minicart\"]"),
            buttonAddToWishList = $x("//div[@data-role=\"add-to-links\"]/a[1]"),
            buttonProceedToCheckout = $x("//*[@id=\"top-cart-btn-checkout\"]"),
            messageSuccess = $x("//div[@data-ui-id=\"message-success\"]");

    /**
     * Выбор размера и цвета товара
     */
    @Step("Выбор размера и цвета товара")
    public void choiceParametersProduct(){
        optionSize.shouldBe(visible).click();
        optionColor.shouldBe(visible).click();
    }
    /**
     * Нажатие на кнопку "Add To Card"
     */
    @Step("Нажатие на кнопку Add To Card")
    public void tabAddToCard(){
        buttonAddToCard.shouldBe(visible, Duration.ofSeconds(20)).click();
    }
    /**
     * Нажатие на логотип корзины
     */
    @Step("Нажатие на логотип корзины в верхнем правом углу страницы")
    public void tabCard(){
        iconCard.shouldBe(visible).click();
    }
    /**
     * Добавление товара в избранное
     */
    @Step("Нажатие на кнопку Add To Wish List")
    public WishListPage tabAddToWishList(){
        buttonAddToWishList.click();
        return new WishListPage();
    }
    /**
     * Нажатие на кнопку "Proceed To Checkout"
     */
    @Step("Нажатие на кнопку Proceed To Checkout")
    public CheckoutPage tabProceedToCheckout(){
        buttonProceedToCheckout.shouldBe(visible).click();
        return new CheckoutPage();
    }
    /**
     * Проверка сообщения об успешном добавлении товара в корзину
     */
    @Step("Проверка появления сообщения об успешном добавлении товара в корзину")
    public boolean isVisibleMessengerSuccess(){
        return messageSuccess.shouldBe(visible).isDisplayed();
    }
}
