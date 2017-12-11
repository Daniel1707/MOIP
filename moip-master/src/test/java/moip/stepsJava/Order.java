package moip.stepsJava;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.OrderJson;
import moip.utilities.Requests;
import moip.utilities.Suports;

public class Order {
    @Given("^i want an order$")
    public void i_want_an_order() throws Throwable {
    	String jsonRequestOrder = OrderJson.create();
		String response = Requests.post("/v2/orders", jsonRequestOrder);

		System.out.println(Suports.keyValueReturn(response, "id"));
		Assert.assertNotNull(Suports.keyValueReturn(response, "id"));
    }

    @When("^i fill all required fields and associate a client to order$")
    public void i_fill_all_required_fields_and_associate_a_client_to_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^an order will be created$")
    public void an_order_will_be_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^i want to create an order$")
    public void i_want_to_create_an_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^i fill all required field and associate a client to order$")
    public void i_fill_all_required_field_and_associate_a_client_to_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

}
