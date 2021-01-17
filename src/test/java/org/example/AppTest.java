package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.example.Base.BasePage;
import org.example.Base.BaseUiTest;
import org.example.Pages.Dairy.ru.HomePage;
import org.example.Pages.Dairy.ru.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.example.Common.Configuration.*;


public class AppTest extends BaseUiTest {

    @Test
    @DisplayName("Добавление записи в дневник")
    @Description("Добавление записи в дневник")
    @Feature("Posting")
    public void addMessageTest() {
        daLogin();
        new HomePage(driver)
                .clickNewPostButton()
                .enterTitle(POST_TITLE)
                .enterMessage(POST_MESSAGE)
                .clickPostButton()
                .addPostCheck();
        daLogout();
    }

    @Test
    @DisplayName("Добавление записи в цитатник")
    @Description("Добавление записи в цитатник")
    @Feature("Fave")
    public void addQuoteTest() {
        daLogin();
        new HomePage(driver)
                .clickDropCommonButton()
                .clickRandomButton()
                .clickAddQuoteButton()
                .addQuoteCheck();
        driver.get(LINK);
        daLogout();
    }

    @Test
    @DisplayName("Добавление случайного дневника в избранное")
    @Description("Добавление случайного дневника в избранное")
    @Feature("Fave")
    public void addFaveTest() {
        daLogin();
        new HomePage(driver)
                .clickDropCommonButton()
                .clickRandomButton()
                .clickAddFaveButton()
                .addFaveCheck();
        driver.get(LINK);
        daLogout();
    }

    @Test
    @DisplayName("Вступление в сообщество")
    @Description("Вступление в сообщество")
    @Feature("Groups")
    public void addGroupTest() {
        daLogin();
        new HomePage(driver)
                .clickDropCommonButton()
                .clickGroupsButton()
                .clickRandomGroup()
                .clickJoinGroupButton()
                .joinGroupCheck();
        driver.get(LINK);
        daLogout();
    }
    @Step(value = "Выполнен вход")
    public void daLogin() {
        driver.get(LINK);
        new LoginPage(driver)
                .clickDropLoginButton()
                .enterLogin(LOGIN)
                .enterPass(PASSWORD)
                .clickLoginButton();
        Assertions.assertTrue(BasePage.isElementPresent(By.className("username")), "Неудалось выполнить вход");
    }
    @Step(value = "Выполнен выход")
    public void daLogout() {
        new HomePage(driver)
                .clickDropCommon2Button()
                .clickLogoutButton();
        Assertions.assertTrue(BasePage.isElementPresent(By.id("loginform")), "Не удалось выполнить выход");
    }

}
