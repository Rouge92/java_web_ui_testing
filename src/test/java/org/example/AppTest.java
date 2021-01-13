package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Base.BaseUiTest;
import org.example.Pages.Dairy.ru.HomePage;
import org.example.Pages.Dairy.ru.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.example.Common.Configuration.*;


public class AppTest extends BaseUiTest {

    @Test
    @DisplayName("Добавление записи в дневник")
    public void addMessageTest() {
        Logger logger = Logger.getLogger(AppTest.class);

        daLogin();
        logger.info("Вход выполнен успешно");
        new HomePage(driver)
                .clickNewPostButton()
                .enterTitle(POST_TITLE)
                .enterMessage(POST_MESSAGE)
                .clickPostButton()
                .addPostCheck();
        logger.info("Запись успешно добавлена");
        daLogout();
        logger.info("Выполнен выход");
        driver.close();
    }

    @Test
    @DisplayName("Добавление записи в цитатник")
    public void addQuoteTest() {
        Logger logger = Logger.getLogger(AppTest.class);
        daLogin();
        logger.info("Вход выполнен успешно");
        new HomePage(driver)
                .clickDropCommonButton()
                .clickRandomButton()
                .clickAddQuoteButton()
                .addQuoteCheck();
        logger.info("Запись успешно процитирована");
        driver.get(LINK);
        daLogout();
        logger.info("Выполнен выход");
        driver.close();
    }

    @Test
    @DisplayName("Добавление случайного дневника в избранное")
    public void addFaveTest() {
        Logger logger = Logger.getLogger(AppTest.class);
        daLogin();
        logger.info("Вход выполнен успешно");
        new HomePage(driver)
                .clickDropCommonButton()
                .clickRandomButton()
                .clickAddFaveButton()
                .addFaveCheck();
        logger.info("Дневник добавлен в избранное");
        driver.get(LINK);
        daLogout();
        driver.close();
    }

    @Test
    @DisplayName("Вступление в сообщество")
    public void addGroupTest() {
        Logger logger = Logger.getLogger(AppTest.class);
        daLogin();
        logger.info("Вход выполнен успешно");
        new HomePage(driver)
                .clickDropCommonButton()
                .clickGroupsButton()
                .clickRandomGroup()
                .clickJoinGroupButton()
                .joinGroupCheck();
        driver.get(LINK);
        daLogout();
        driver.close();
    }

    public void daLogin() {
        driver.get(LINK);
        new LoginPage(driver)
                .clickDropLoginButton()
                .enterLogin(LOGIN)
                .enterPass(PASSWORD)
                .clickLoginButton();
        Assertions.assertTrue(BasePage.isElementPresent(By.className("username")), "Неудалось выполнить вход");
    }

    public void daLogout() {
        new HomePage(driver)
                .clickDropCommon2Button()
                .clickLogoutButton();
        Assertions.assertTrue(BasePage.isElementPresent(By.id("loginform")), "Не удалось выполнить выход");
    }

}
