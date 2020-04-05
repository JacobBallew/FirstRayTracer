package cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloWorldSteps {

    String greeting;

    @Given("I am alive")
    public void i_am_alive() {
        if ((1 + 1) == 2) {
            System.out.println("I'm Alive!");
        }
    }

    @When("I speak, I will output words")
    public void i_speak_I_will_output_words() {
        greeting = "Hello World";
    }

    @Then("I will be heard")
    public void i_will_be_heard() {
        System.out.println(greeting);
    }
}
