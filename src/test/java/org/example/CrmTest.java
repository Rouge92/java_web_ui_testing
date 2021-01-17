package org.example;

import io.qameta.allure.Step;
import org.example.Base.BasePage;
import org.example.Base.BaseUiTest;
import org.example.Enums.CounterSubMenuButtons;
import org.example.Enums.NavigationBarTabs;
import org.example.Enums.ProjectSubMenuButtons;
import org.example.Pages.CRM.AllContactsPage;
import org.example.Pages.CRM.AllProjectsPage;
import org.example.Pages.CRM.CRMHomePage;
import org.example.Pages.CRM.CRMLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import io.qameta.allure.Feature;
import io.qameta.allure.Description;

import static org.example.Common.Configuration.*;

public class CrmTest extends BaseUiTest {

    @Test
    @DisplayName("Создание проекта")
    @Description("Создание проекта")
    @Feature("Project")
    public void createProjectTest() {
        crmLogin();
        new CRMHomePage(driver)
                .getNavigation()
                .moveCursorTooNavigationTab(NavigationBarTabs.PROJECTS)
                .clickSubMenuButton(ProjectSubMenuButtons.MY_PROJECTS);
        new AllProjectsPage(driver)
                .clickNewProject()
                .enterProjectName("Kill_star")
                .clickCompanyList()
                .clickSeceltedCompany()
                .selectBusinessUnit(1)
                .selectCurator(33)
                .selectRP(83)
                .selectManager(6)
                .selectContsctMain(189)
                .clickSubmit()
                .checkNewProject();
        crmLogout();
    }

    @Test
    @DisplayName("Создание контактного лица")
    @Description("Создание контактного лица")
    @Feature("Contacts")
    public void createContactTest() {
        crmLogin();
        new CRMHomePage(driver)
                .getNavigation()
                .moveCursorTooNavigationTab(NavigationBarTabs.COUNTER)
                .clickSubMenuButton(CounterSubMenuButtons.CONTACTS);
        new AllContactsPage(driver)
                .clickNewContact()
                .enterLastName("Маркс")
                .enterFirstName("Карл")
                .clickCompanyList()
                .clickSeceltedCompany()
                .enterJobTitle("PR менеджер")
                .clickSubmit()
                .checkNewContact();
        crmLogout();
    }

    @Step("Выполнен вход")
    public void crmLogin() {
        driver.get(LINK_CRM);
        new CRMLoginPage(driver)
                .crmEnterLogin(LOGIN_CRM)
                .crmEnterPass(PASSWORD_CRM)
                .crmClickLoginButton();
        Assertions.assertTrue(BasePage.isElementPresent(By.id("progressbar")), "Не удалось выполнить вход");
    }
    @Step("Выполнен выход")
    public void crmLogout() {
        new CRMHomePage(driver)
                .clickUserMenu()
                .clickUserLogout();
        Assertions.assertTrue(BasePage.isElementPresent(By.id("login-form")), "Не удалось выполнить выход");
    }

}
