package org.example.Pages.Dairy.ru;

import org.example.Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SomeDairyPage extends BasePage {

    @FindBy(linkText = "В цитатник")
    private WebElement addQuote;

    @FindBy(linkText = "Добавить в избранное")
    private WebElement addFave;

    @FindBy(linkText = "Вступить в сообщество")
    private WebElement joinGroup;

    public SomeDairyPage clickAddQuoteButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(addQuote));
        addQuote.click();
        return this;
    }

    public SomeDairyPage clickAddFaveButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(addFave));
        addFave.click();
        return this;
    }

    public SomeDairyPage clickJoinGroupButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(joinGroup));
        joinGroup.click();
        return this;
    }

    public SomeDairyPage addQuoteCheck() {
        Assertions.assertTrue(BasePage.isElementPresent(By.linkText("Удалить из цитатника")), "Запись не процитирована");
        return this;
    }

    public SomeDairyPage addFaveCheck() {
        Assertions.assertTrue(isElementPresent(By.linkText("Удалить из избранного")), "Не удалось добавить в избраное");
        return this;
    }

    public SomeDairyPage joinGroupCheck() {
        Assertions.assertTrue(isElementPresent(By.linkText("Написать в сообщество")), "Не удалось вступить в сообщество");
        return this;
    }

    public SomeDairyPage(WebDriver driver) {
        super(driver);
    }
}
