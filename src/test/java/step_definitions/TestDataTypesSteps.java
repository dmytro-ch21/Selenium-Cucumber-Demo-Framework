package step_definitions;

import io.cucumber.java.en.Given;

public class TestDataTypesSteps {

    @Given("test with double {double}")
    public void test_with_double(Double double1) {
        System.out.println(double1);
    }
    @Given("test with int {int}")
    public void test_with_int(Integer int1) {
        System.out.println(int1);
    }
    @Given("test with string {string}")
    public void test_with_string(String string) {
        System.out.println(string);
    }


}
