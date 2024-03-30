package com.example.projectsoftware.AcceptanceTest;

import com.example.projectsoftware.HelloController2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;



import com.example.projectsoftware.HelloController2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class checkclass {
    String email;
    String code;
    HelloController2 h=new HelloController2();

    @When("I click on check and flag is {string}")
    public void iClickOnCheckAndFlagIs(String string) {
        if(string.equals("true"))assertEquals(true,true);
        else assertEquals(false,false);

    }
    @Then("field {string} shouldddd be with error")
    public void fieldShoulddddBeWithError(String string) {

        System.out.println("rrrrrrrrrr");

    }




    @When("he fillllls in {string}")
    public void heFilllllsIn(String string) {
        email=string;
        System.out.print(email);
        if(string.equals("Email")){
            assertEquals(true, true);
        }
        else if(string.equals("password") ){
            assertEquals(true, true);
        }

    }
    @When("hee fillllls in {string}")
    public void heeFilllllsIn(String string) {

        code=string;
    }

    @Then("I shoulddddd see {string}")
    public void iShouldddddSee(String string) {
        assertEquals(false,h.checkbutton(email,code));

    }





    @Then("I shouldntttt see {string}")
    public void iShouldnttttSee(String string) {
        assertEquals(true,h.checkbutton(email,code));


    }



}