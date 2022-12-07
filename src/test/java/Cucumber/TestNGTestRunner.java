package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	      features = {"src/test/java/Cucumber"},
	      glue = {"Academy"},
	      monochrome = true,
	      dryRun = false,
	      tags="@Regression",
	      plugin = {
	            "html:target/cucumber.html",
	         
	      })


public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
