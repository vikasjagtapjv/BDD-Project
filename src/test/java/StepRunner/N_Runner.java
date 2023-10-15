package StepRunner;
import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
		features= {"E:\\PracticeExtentMaven\\Features\\New_Login.feature"},
		glue="stepDefination",
		dryRun=false,
	    monochrome=true,
		//plugin= {"pretty","html:target/Cucumber-Reports/reports03.html"
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class N_Runner extends AbstractTestNGCucumberTests { 

}
