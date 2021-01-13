package org.example.Pages.Dairy.ru;

import org.example.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  extends BasePage {

    @FindBy (id = "drop-login")
    private WebElement dropLogin;

    @FindBy (id = "usrlog2")
    private WebElement usrlog;

    @FindBy (id = "usrpass2")
    private WebElement usrpass;

    @FindBy (xpath= "/html/body/div[2]/div/ul[2]/li[1]/div/form/button")
    private WebElement logButton;
    //TODO локатор

    public LoginPage enterLogin (String login){
        usrlog.sendKeys(login);
        return this;
    }

    public LoginPage enterPass (String password){
        usrpass.sendKeys(password);
        return this;
    }
    public HomePage clickLoginButton (){
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable (logButton));
        logButton.click();
        return new HomePage(driver);
    }
    public LoginPage clickDropLoginButton (){
        dropLogin.click();
        return this;
    }
//    public  HomePage autorise (String login, String password){
//        inputLogin.sendKeys(login);
//        inputPassword.sendKeys(password);
//        logButton.click();
//        return new HomePage(driver);
//
//    }


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
