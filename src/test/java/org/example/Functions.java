package org.example;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Functions {

    public static WebDriver openBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  // this i added  this and it worked, Thanks a ton  xinchao zhang !!
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.reddit.com/");
        return driver;
    }
    public static void logInReddit(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(Component_Id.logInBtnMainMenu)).click();
        driver.switchTo().frame(driver.findElement(By.className("_25r3t_lrPF3M6zD2YkWvZU")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Component_Id.emailFieldLogin)).sendKeys("bigicefire");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Component_Id.passwordFieldLogin)).sendKeys("12119031Maxim321");
        wait.until(ExpectedConditions.elementToBeClickable(Component_Id.loginBtn)).click();

    }
    /*

     */

}