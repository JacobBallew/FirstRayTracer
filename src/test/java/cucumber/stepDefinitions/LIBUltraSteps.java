package cucumber.stepDefinitions;

import ballew.rayTracer.utils.LIBUltra;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LIBUltraSteps {

    @Given("I have two same floating point numbers")
    public void i_have_two_same_floating_point_numbers() {
        System.out.println("Same");
        System.out.println("Num1: " + 23.5);
        System.out.println("Num2: " + 23.5);
    }

    @When("I compare them")
    public void i_compare_them() {
        boolean result = LIBUltra.isEqual(23.5, 23.5);
        if (!result){
            Assert.fail();
        }
    }

    @Then("they are equal return true")
    public void they_are_equal_return_true() {
        System.out.println("They are the same: " + LIBUltra.isEqual(23.5, 23.5));
    }

    @Given("I have two different floating point numbers")
    public void i_have_two_different_floating_point_numbers() {
        System.out.println("Different");
        System.out.println("Num1: " + 22);
        System.out.println("Num2: " + 22.00001);
    }

    @When("I compare them again")
    public void i_compare_them_again() {
        boolean result = LIBUltra.isEqual(22, 22.00001);
    }

    @Then("they are not equal return false")
    public void they_are_not_equal_return_false() {
        System.out.println("They are the same: " + LIBUltra.isEqual(24, 24.00001));
    }


}
