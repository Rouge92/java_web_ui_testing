package org.example.Pages.Dairy.ru;

import org.example.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupsPage extends BasePage {

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div[1]/div[2]/div[3]/div[1]/a[2]")
    private WebElement randomGroup;

    public SomeDairyPage clickRandomGroup (){
        randomGroup.click();
        return  new SomeDairyPage(driver);
    }


    public GroupsPage(WebDriver driver) {
        super(driver);
    }
}
