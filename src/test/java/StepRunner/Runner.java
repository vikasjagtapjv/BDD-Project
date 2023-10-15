package StepRunner;


import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(cucumber.class )
//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
		features={"E:\\PracticeExtentMaven\\Features\\Login.feature",
				"E:\\PracticeExtentMaven\\Features\\Customer.feature"},
		glue="stepDefination",
		dryRun=false,
		monochrome=true,
		//plugin= {
				//"pretty","html:target/Cucumber-Reports/reports01.html"
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class Runner extends AbstractTestNGCucumberTests {

}
