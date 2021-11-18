package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public interface page1 {

  WebElement userNameInputBox = Driver.getDriver().findElement(By.name("USER_LOGIN"));

}
