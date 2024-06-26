package org.example;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;

public class CheckoutPage extends BasePage{
    /**
     * Нажатие на кнопку "Place Order"
     */
    @Step("Нажатие на кнопку Place Order")
    public SuccessPage tabPlaceOrder(){
        $(By.xpath("//button[@class=\"action primary checkout\"]")).click();
        return new SuccessPage();
    }
    /**
     * Нажатие на кнопку "Next"
     */
    @Step("Нажатие на кнопку Next")
    public void tabNext(){
        $(By.xpath("//button[@data-role=\"opc-continue\"]")).click();
        Selenide.sleep(3000);
    }
}
