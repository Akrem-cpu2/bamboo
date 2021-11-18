package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.ConfiReader;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authorization  {

    public Authorization(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userNameInputBox;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy(className = "errortext")
    public WebElement ErrorMessage;

    @FindBy(className = "login-item-checkbox-label")
    public WebElement rememberMeCheckBox;

     @FindBy(xpath = "//a[.='Forgot your password?']")
     public WebElement forgotMyPasswordLink;



    public static void inputValidCredentials(String keyword ){

        Pages.getAuthorization().userNameInputBox.sendKeys(ConfiReader.getProperty(keyword));
        Pages.getAuthorization().passwordInputBox.sendKeys(ConfiReader.getProperty("password"));

    }
    public static void inputInvalidCredentials(){
        Pages.getAuthorization().userNameInputBox.sendKeys("Incorrect@cybertekschool.com");
        Pages.getAuthorization().passwordInputBox.sendKeys("incorrect");
    }



}
