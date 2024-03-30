package com.example.projectsoftware.AcceptanceTest;

import com.example.projectsoftware.HelloController2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class login {


        public String em;
        public  String pass;
        HelloController2 ob= new HelloController2();
        @When("I click on login and flag is {string}")
        public void iClickOnLoginAndFlagIs(String string) {
            if(string.equals("true"))assertEquals(true,true);
            else assertEquals(false,false);
        }
        @Then("field {string} should be with error")
        public void fieldShouldBeWithError(String string) {
            System.out.println("lllllllllllllllllll");
        }

        @When("he fills in {string}")
        public void heFillsIn(String string) {

            em=string;
            System.out.print(em);
            if(string.equals("Email")){
                assertEquals(true, true);
            }
            else if(string.equals("password") ){
                assertEquals(true, true);
            }
        }
        @When("hee fills in {string}")
        public void heeFillsIn(String string) {
            pass=string;

        }
        @Then("I should see {string}")
        public void iShouldSee(String string) {
            assertEquals(false,ob.login1Clicked(em,pass));
        }
        @Then("I shouldnt see {string}")
        public void iShouldntSee(String string) {
            assertEquals(true,ob.login1Clicked(em,pass));
        }

    }

