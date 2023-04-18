package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Tests {
    private static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        driver = Functions.openBrowser();

    }

    @AfterClass
    public static void afterClass() {

    }

    @Test
    public void test1() throws InterruptedException {
        Functions.logInReddit(driver);
    }
    @Test
    public void test2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(Component_Id.logInBtnMainMenu).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(Component_Id.firstPostTitle)).getText());

    }
}
