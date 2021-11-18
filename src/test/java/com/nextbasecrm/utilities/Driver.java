package com.nextbasecrm.utilities;

import com.nextbasecrm.step_defentions.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);
    private Driver(){}



    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (driverPool.get() == null){
             synchronized (Driver.class) {

                 String browserType = ConfiReader.getProperty("browser");
                 Properties properties = new Properties();
                 try {
                     properties.load(Driver.class.getClassLoader().getResourceAsStream("test.Properties"));
                 }catch (IOException e){
                     System.out.println("pass the value of headless");
                 }
                 boolean headless = properties.getProperty("browserType").equalsIgnoreCase("true");
                 System.out.println("properties.getProperty(\"browserType\") = " + properties.getProperty("browserType"));

                 logger.debug( ("this is from mvn command = ").concat(properties.getProperty("browserType")));


                 switch (browserType) {
                     case "chrome":
                         ChromeOptions options = new ChromeOptions();
                         options.setHeadless(headless);
                         WebDriverManager.chromedriver().setup();
                         driverPool.set(new ChromeDriver(options));
                         driverPool.get().manage().window().maximize();
                         driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         break;

                 }
             }
        }


        return  driverPool.get();


    }


    public static void closeDriver(){
        if( driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
          
        }
    }


}
