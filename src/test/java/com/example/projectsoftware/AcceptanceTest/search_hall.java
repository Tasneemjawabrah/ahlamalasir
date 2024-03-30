package com.example.projectsoftware.AcceptanceTest;

import com.example.projectsoftware.Halls;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class search_hall {
    Halls obbj=new Halls();
    String x;



    @When("he search about {string}")
    public void heSearchAbout(String string) {
        x=string;
    }
    @Then("I shouldd see {string}")
    public void iShoulddSee(String string) {
        assertEquals(false,obbj.isHallExists(x));
    }


    @Then("I sshould see {string}")
    public void iSshouldSee(String string) {

        assertEquals(true,obbj.isHallExists(x));
    }



}


