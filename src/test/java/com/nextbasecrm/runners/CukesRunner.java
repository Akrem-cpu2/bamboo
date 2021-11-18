package com.nextbasecrm.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features ="src/test/resources/features",
        glue = "com/nextbasecrm/step_defentions",
        dryRun =  false,
        tags = "@wip"


)

public class CukesRunner {

}

