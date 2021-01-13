package org.example.Pages.Dairy.ru;

import org.example.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage {

    @FindBy(id = "postTitle")
    private WebElement postTitle;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(id = "rewrite")
    private WebElement rewrite;


    public PostPage enterTitle(String posttitle) {
        postTitle.sendKeys(posttitle);
        return this;
    }

    public PostPage enterMessage(String mes) {
        message.sendKeys(mes);
        return this;
    }

    public HomePage clickPostButton() {
        rewrite.click();
        return new HomePage(driver);
    }

    public PostPage(WebDriver driver) {
        super(driver);
    }
}
