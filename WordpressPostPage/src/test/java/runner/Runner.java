package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)				
	@CucumberOptions(
		features="feature/Post_modulo/",
		glue = {"stepDefinition.Post"},
		plugin = {
		    "pretty",
		    "json:build/cucumber-report/cucumber.json",
		    "html:build/cucumber-report/cucumber.html",
		    "junit:build/cucumber-report/cucumber.xml"
		}
	)						
	public class Runner {		

	}

