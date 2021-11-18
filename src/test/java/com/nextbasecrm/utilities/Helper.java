package com.nextbasecrm.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;

public class Helper {
    public static void highlightElement( WebElement element)  {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');" , element);

        BrowserUtils.sleep(2);

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');" , element);



    }
}
