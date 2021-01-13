package org.example.Pages.CRM;

import org.example.Base.BasePage;
import org.example.Views.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMHomePage extends BasePage {

    private NavigationBar navigationBar;

    @FindBy(className = "dropdown-toggle")
    private WebElement userMenu;

    @FindBy(className = "no-hash")
    private WebElement userLogout;

    public CRMHomePage clickUserMenu() {
        userMenu.click();
        return this;
    }

    public CRMLoginPage clickUserLogout() {
        userLogout.click();
        return new CRMLoginPage(driver);
    }

    public CRMHomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public NavigationBar getNavigation() {
        return navigationBar;
    }
}