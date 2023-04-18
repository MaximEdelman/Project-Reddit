package org.example;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.switchTo().defaultContent();

    }
    public static String findTitleByOrder(int titleNumber, WebDriver driver) {
        List<WebElement> titles = driver.findElements(Component_Id.titleOfPosts);
        String title = titles.get(titleNumber - 1).getText();
        return title;
    }

    public static int findUpvotesByOrder(int upvoteNumber, WebDriver driver){
        List<WebElement> upvotes = driver.findElements(Component_Id.upvotesByOrder);

        // remove duplicates using a HashSet
        Set<String> uniqueUpvotes = new HashSet<>();
        for (WebElement upvote : upvotes) {
            String upvoteText = upvote.getText().replaceAll("\\bvote\\b", "").trim();
            if (!upvoteText.isEmpty()) {
                uniqueUpvotes.add(upvoteText);
            }
        }

        // remove every 2nd element from the list
        List<String> uniqueUpvotesList = new ArrayList<>(uniqueUpvotes);
        for (int i = uniqueUpvotesList.size() - 1; i >= 0; i -= 2) {
            uniqueUpvotesList.remove(i);
        }

        String upvote = uniqueUpvotesList.get(upvoteNumber - 1);
        int numberOfUpvotes = Integer.parseInt(upvote);
        return numberOfUpvotes;
    }

}