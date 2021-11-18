package com.nextbasecrm.testbase;

import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {
  @Before
 public void setup(){
      Driver.getDriver().get("login2.nextbasecrm.com");
  }
  @After
    public void close(){
      Driver.closeDriver();
  }

  
}
