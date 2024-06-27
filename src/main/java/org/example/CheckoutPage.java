package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;

public class CheckoutPage {

    public final SelenideElement
            buttonPlaceOrder = $x("//button[@class=\"action primary checkout\"]"),
            buttonNext = $x("//button[@data-role=\"opc-continue\"]");
    /**
     * Нажатие на кнопку "Place Order"
     */
    @Step("Нажатие на кнопку Place Order")
    public SuccessPage tabPlaceOrder(){
        buttonPlaceOrder.shouldBe(visible).click();
        return new SuccessPage();
    }
    /**
     * Нажатие на кнопку "Next"
     */
    @Step("Нажатие на кнопку Next")
    public void tabNext(){
        buttonNext.shouldBe(visible).click();
    }
}
