package com.example.projectsoftware.AcceptanceTest;
import io.cucumber.junit.Cucumber;
import io.cucumber. junit. CucumberOptions;
import io.cucumber. junit.CucumberOptions.SnippetType;
import org. junit.runner. RunWith;

@RunWith(Cucumber.class)

@CucumberOptions (features = "cases", monochrome = true,snippets = SnippetType.CAMELCASE,
        plugin = {"html:target/cucumber/wikipedia.html"},
        glue = {"com.example.projectsoftware.AcceptanceTest"})

public class acceptanceTest {

}
