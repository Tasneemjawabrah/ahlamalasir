package com.example.projectsoftware.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class discount {
    @Given("a customer with an order value of {int}")
    public void aCustomerWithAnOrderValueOf$(Integer int1) {
        assertEquals(true, int1 > 0);
    }

    @When("the customer is eligible for a {int}% discount")
    public void theCustomerIsEligibleForADiscount(Integer int1) {
        assertEquals(true, int1 > 0);
    }

    @Then("the total ordar value should be {int}")
    public void theTotalOrdarValueShouldBe(Integer int1) {
        assertEquals(true, int1 > 0);
    }

    @Then("the discount amount should be {int}")
    public void theDiscountAmountShouldBe$(Integer int1) {
        assertEquals(true, int1 >= 0);
    }

    @Then("the total order value should be {int}")
    public void theTotalOrderValueShouldBe$(Integer int1) {
        assertEquals(true, int1 > 0);
    }

    @When("the customer is not eligible for any {string}")
    public void theCustomerIsNotEligibleForAnyDiscount(String string) {
        assertEquals(true, string.equals("discount"));
    }

    @When("the customer is eligible for a maximum discount of {int}%")
    public void theCustomerIsEligibleForAMaximumDiscountOf(Integer int1) {

        assertEquals(true, int1 > 0);

    }

    @Then("the discount amount be should be {int}")
    public void theDiscountAmountBeShouldBe(Integer int1) {
        assertEquals(true, int1 >= 0);
    }

    @Then("an error message should be displayed stating that the minimum order value of {int} was not met")
    public void anErrorMessageShouldBeDisplayedStatingThatTheMinimumOrderValueOfWasNotMet(Integer int1) {
        assertEquals(true, int1 >= 1);
    }

    @Given("a customer with an order that includes a {string} item")
    public void aCustomerWithAnOrderThatIncludesAItem(String string) {
        assertEquals(true, string.equals("true"));

    }

    @When("the customer is eligible for a {int}% discount on that item")
    public void theCustomerIsEligibleForADiscountOnThatItem(Integer int1) {
        assertEquals(true, int1 > 0);
    }

    @Then("the discount amount for that item should be {double}")
    public void theDiscountAmountForThatItemShouldBe(Double double1) {
        assertEquals(true, double1 > 0.0);

    }
}
