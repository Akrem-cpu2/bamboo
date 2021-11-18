package com.nextbasecrm.step_defentions;

import com.nextbasecrm.utilities.ConfiReader;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Hooks {
    @Before
    public void setup()  {
        Driver.getDriver().get("https://login2.nextbasecrm.com/");
        Properties properties = new Properties();

    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenShot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",scenario.getName());
        }


        System.out.println("scenario.getStatus().toString() = " + scenario.getStatus().toString());
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getId() = " + scenario.getId());


        if(Pages.getStream() !=null){
           Pages.closeStream();
       }
       if(Pages.getAuthorization() != null){
           Pages.closeAuthorization();
       }

        Driver.closeDriver();



    }
}
