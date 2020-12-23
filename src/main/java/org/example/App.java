package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {
    public static WebDriver driver;

    public static void main(String[] args)  {
        test_1();
        test_2();
        driver.quit();

    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static void test_1() {
        getDriver();
        driver.get("https://www.diary.ru/");
        WebElement login = driver.findElement(By.id("drop-login"));
        login.click();
        WebElement userlog = driver.findElement(By.id("usrlog2"));
        userlog.click();
        userlog.sendKeys("QA_2021");
        WebElement userpass = driver.findElement(By.id("usrpass2"));
        userpass.click();
        userpass.sendKeys("e95a149db");
        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[1]/div/form/button"));
        submit.click();
        WebElement newpost = driver.findElement(By.className("i-menu-newpost"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(newpost));
        newpost.click();
        WebElement posttitle = driver.findElement(By.id("postTitle"));
        posttitle.click();
        posttitle.sendKeys("Test message");
        WebElement message = driver.findElement(By.id("message"));
        message.click();
        message.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,\n\n");
        WebElement rewrite = driver.findElement(By.id("rewrite"));
        rewrite.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (!isElementPresent(By.linkText("Комментировать"))) {
            driver.quit();
            throw new NoSuchElementException("Запись не добавлена");
        }
        WebElement drop2 = driver.findElement(By.id("drop"));
        drop2.click();
        WebElement logout = driver.findElement(By.linkText("Выход"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        driver.close();
    }

    public static void test_2() {
        getDriver();
        driver.get("https://www.diary.ru/");
        WebElement login = driver.findElement(By.id("drop-login"));
        login.click();
        WebElement userlog = driver.findElement(By.id("usrlog2"));
        userlog.click();
        userlog.sendKeys("QA_2021");
        WebElement userpass = driver.findElement(By.id("usrpass2"));
        userpass.click();
        userpass.sendKeys("e95a149db");
        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[1]/div/form/button"));
        submit.click();
        WebElement drop = driver.findElement(By.id("drop-common"));
        drop.click();
        WebElement random = driver.findElement(By.linkText("Случайный дневник"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(random));
        random.click();
        WebElement addQuote = driver.findElement(By.linkText("В цитатник"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(addQuote));
        addQuote.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (!isElementPresent(By.linkText("Удалить из цитатника"))) {
            driver.quit();
            throw new NoSuchElementException("Запись не процитирована!");
        }
        driver.get("https://www.diary.ru/");
        WebElement drop2 = driver.findElement(By.id("drop"));
        drop2.click();
        WebElement logout = driver.findElement(By.linkText("Выход"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        driver.close();
    }

    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}