package cucumber.stepDefinitions;

import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Tuple;
import ballew.rayTracer.domain.TupleFactory;
import ballew.rayTracer.domain.Vector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TupleTypeTests {

    /*
    Plain old Tuples
     */

    Tuple tuple1, tuple2;
    Point point1, point2;
    Vector vector1, vector2;

    @Given("I have no tuple")
    public void i_have_no_tuple() {
        tuple1 = null;
    }

    @When("I create a tuple")
    public void i_create_a_tuple() {
        tuple1 = new Tuple(1d, 2d, 3d, 4d);
    }

    @Then("I have a tuple")
    public void i_have_a_tuple() {
        System.out.println(tuple1);
    }

    /*
    Point tests
     */
    @Given("I have no point")
    public void i_have_no_point() {
        point1 = null;
    }

    @When("I create a point")
    public void i_create_a_point() {
        point1 = new Point(1, 2, 3);
    }

    @Then("I have a point")
    public void i_have_a_point() {
        System.out.println(point1);
        System.out.println("This is a point: " + point1.isPoint());
        System.out.println("This is a vector: " + point1.isVector());
    }

    /*
    Vector tests
     */
    @Given("I have no vector")
    public void i_have_no_vector() {
        vector1 = null;
    }

    @When("I create a vector")
    public void i_create_a_vector() {
        vector1 = new Vector(1, 2, 3);
    }

    @Then("I have a vector")
    public void i_have_a_vector() {
        System.out.println(vector1);
        System.out.println("Is a point: " + vector1.isPoint());
        System.out.println("Is a point: " + vector1.isVector());
    }

    /*
    Tuple Factor
     */
    @Given("I have not point or vector")
    public void i_have_not_point_or_vector() {
        point2 = null;
        vector2 = null;
    }

    @When("I use the Tuple Factory")
    public void i_use_the_Tuple_Factory() {
        point2 = TupleFactory.point(1, 2, 3);
        vector2 = TupleFactory.vector(1, 3, 4);
    }

    @Then("I can create a Point and Vector")
    public void i_can_create_a_Point_and_Vector() {
        System.out.println(vector2);
        System.out.println("Is a vector: " + vector2.isVector());

        System.out.println(point2);
        System.out.println("This is a point: " + point2.isPoint());
    }


}
