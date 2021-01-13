package org.example.Views;

import org.example.Base.BasePage;
import org.example.Base.SubMenu;
import org.example.Base.SubMenuButtons;
import org.example.Enums.CounterSubMenuButtons;
import org.example.Enums.ProjectSubMenuButtons;
import org.example.Pages.CRM.AllContactsPage;
import org.example.Pages.CRM.AllProjectsPage;
import org.openqa.selenium.WebDriver;

public class ProjectSubMenu extends SubMenu {

    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectSubMenuButtons) {
            switch ((ProjectSubMenuButtons) buttons) {
                case MY_PROJECTS:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new AllProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("not implemented yet");
            }
        } else {
            if (buttons instanceof CounterSubMenuButtons) {
                switch ((CounterSubMenuButtons) buttons) {
                    case CONTACTS:
                        driver.findElement(((CounterSubMenuButtons) buttons).getBy()).click();
                        return new AllContactsPage(driver);
                    default:
                        throw new IllegalArgumentException("not implemented yet");
                }
            } else {
                throw new IllegalArgumentException("Incorrect button");
            }
        }
    }
}

