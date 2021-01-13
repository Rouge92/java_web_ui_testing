package org.example.Pages.Dairy.ru;

import org.example.Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public PostPage clickNewPostButton (){
        newPost.click();
        return new PostPage(driver);
    }
    public HomePage clickDropCommonButton (){
        dropCommon.click();
        return this;
    }

    public HomePage clickDropCommon2Button (){
        drop2.click();
        return this;
    }
    public HomePage clickLogoutButton (){
        logout.click();
        return this;
    }

    public SomeDairyPage clickRandomButton (){
        random.click();
        return  new SomeDairyPage(driver);
    }

    public GroupsPage clickGroupsButton (){
        groups.click();
        return  new GroupsPage(driver);
    }

    public HomePage addPostCheck (){
        Assertions.assertTrue(isElementPresent(By.linkText("Комментировать")), "Запись не добавлена");
        return this;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
