package org.example.Pages.Dairy.ru;

import io.qameta.allure.Step;
import org.example.Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(className = "i-menu-newpost")
    private WebElement newPost;

    @FindBy(id = "drop-common")
    private WebElement dropCommon;

    @FindBy(id = "drop")
    private WebElement drop2;

    @FindBy(linkText = "Выход")
    private WebElement logout;


    @FindBy(linkText = "Случайный дневник")
    private WebElement random;

    @FindBy(linkText = "Все сообщества")
    private WebElement groups;

    @Step("Клик +Новая запись")
    public PostPage clickNewPostButton() {
        newPost.click();
        return new PostPage(driver);
    }

    @Step("Клик Меню сайта")
    public HomePage clickDropCommonButton() {
        dropCommon.click();
        return this;
    }

    @Step("Клик Меню позьзователя")
    public HomePage clickDropCommon2Button() {
        drop2.click();
        return this;
    }

    @Step("Клик Выход")
    public HomePage clickLogoutButton() {
        logout.click();
        return this;
    }

    @Step("Клик Случайный дневник")
    public SomeDairyPage clickRandomButton() {
        random.click();
        return new SomeDairyPage(driver);
    }

    @Step("Клик на Сообщества")
    public GroupsPage clickGroupsButton() {
        groups.click();
        return new GroupsPage(driver);
    }

    @Step( "Запись добавлена")
    public HomePage addPostCheck() {
        Assertions.assertTrue(isElementPresent(By.linkText("Комментировать")), "Запись не добавлена");
        return this;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
