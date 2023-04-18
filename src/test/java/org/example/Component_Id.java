package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Component_Id {
    //register btn at the main screen
    static By logInBtnMainMenu = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[2]/div/div[1]/a");

    //email field when logging in
    static By emailFieldLogin = By.xpath("//*[@id=\"loginUsername\"]");
    //password field when logging in
    static By passwordFieldLogin = By.xpath("//*[@id=\"loginPassword\"]");
    static By loginBtn = By.xpath("/html/body/div/main/div[1]/div/div/form/fieldset[4]/button");

    static By titleOfPosts = By.xpath("//*/div[3]/div[2]/div[1]|\n" +
            "//*/div[2]/article/div[1]/div[2]/div[1]\n");

    static By upvotesByOrder = By.xpath("//*[contains(@id, 'vote-arrows')]");


}
