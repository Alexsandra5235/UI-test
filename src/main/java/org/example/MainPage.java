package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public final SelenideElement
            createAnAccountLnk = $x("//div[@class=\"panel header\"]/ul[@class=\"header links\"]/li[3]/a"),
            elementPage = $x("//div[@class=\"sections nav-sections\"]"),
            buttonCategoryWomen = $x("//*[@id=\"ui-id-4\"]"),
            buttonCategoryTops = $x("//*[@id=\"ui-id-9\"]"),
            textBoxSearchBar = $x("//*[@id=\"search\"]");
    public final ElementsCollection
            signInLnk = $$x("//ul[@class=\"header links\"]/li/a"),
            dropDown = $$x("//button[@class=\"action switch\"]"),
            buttonMyAccount = $$x("//ul[@class=\"header links\"]/li/a");
    /**
     * Нажатие на кнопку "Create An Account"
     */
    @Step("Нажатие на кнопку Create An Account")
    public CreateNewAccountPage tabCreateAnAccount(){
        createAnAccountLnk.shouldBe(visible).click();
        return new CreateNewAccountPage();
    }
    /**
     * Нажатие на категорию "Women"
     */
    @Step("Нажатие на категорию Women")
    public CategoryWomenPage tabWomen(){
        buttonCategoryWomen.shouldBe(visible).click();
        return new CategoryWomenPage();
    }
    /**
     * Нажатие на категорию "Tops"
     */
    @Step("Нажатие на категорию Tops")
    public CategoryTopsPage tabTops(){
        buttonCategoryWomen.shouldBe(visible).hover();
        buttonCategoryTops.shouldBe(visible).click();
        return new CategoryTopsPage();
    }
    /**
     * Ввод текстового запроса и нажатие кнопки Enter
     */
    @Step("Ввод текстового запроса и нажатие кнопки Enter")
    public ResultQueryPage fullingSearchQuery(){
        textBoxSearchBar.sendKeys(Constants.searchQuery);
        textBoxSearchBar.sendKeys(Keys.ENTER);
        return new ResultQueryPage();
    }
    /**
     * Нажатие на кнопку "Sign In"
     */
    @Step("Нажатие на ссылку Sign In в верхней правой части сайта")
    public SignInPage tabSignIn(){
        signInLnk.first().shouldBe(visible).click();
        return new SignInPage();
    }
    /**
     * Нажатие на кнопку открытия выпадающего списка перехода между страницами
     */
    @Step("Нажатие на выпадающий список перехода между страницами")
    public void tabDropDown(){
        dropDown.first().shouldBe(visible).click();
    }
    /**
     * Нажатие на кнопку "My Account"
     */
    @Step("Нажатие в выпадающем списке на кнопку My Account")
    public MyAccountPage tabMyAccount(){
        buttonMyAccount.first().shouldBe(visible).click();
        return new MyAccountPage();
    }
    /**
     * Проверка отображения элемента страницы
     */
    @Step("Проверка отображения элемента на главной странице сайта")
    public boolean isVisibleItemPage(){
        return elementPage.shouldBe(visible).isDisplayed();
    }
}