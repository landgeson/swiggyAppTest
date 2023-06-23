package TestRunner;
import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features"},
		glue= {"StepDef"},
	    dryRun = false,
	    monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class Run extends AbstractTestNGCucumberTests {

}
