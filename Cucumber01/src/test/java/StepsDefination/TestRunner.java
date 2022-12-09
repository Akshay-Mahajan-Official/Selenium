package StepsDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features",
glue={"StepsDefination"},
plugin = {"pretty","junit:target/JUnitReports/reports.xml",
"json:target/JsonReports/reports.json",
"html:target/HtmlReports"}
)
public class TestRunner {

}
