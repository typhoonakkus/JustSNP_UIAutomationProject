package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepDef", "Hooks"},
		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class Runner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false) // TestNG paralel çalıştırma
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
