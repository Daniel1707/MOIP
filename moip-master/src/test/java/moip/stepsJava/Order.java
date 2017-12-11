package moip.stepsJava;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.OrderJson;
import moip.utilities.ExternalData;
import moip.utilities.Requests;
import moip.utilities.Suports;

public class Order {

	String jsonRequestOrder;
	String response;

	@Given("^i want to create an order$")
	public void i_want_an_order() throws Throwable {
		jsonRequestOrder = OrderJson.createOrderAsExistingUser();
	}

	@When("^i fill all required fields and associate a client to order$")
	public void i_fill_all_required_fields_and_associate_a_client_to_order() throws Throwable {
		response = Requests.post("/v2/orders", jsonRequestOrder);
	}

	@Then("^an order will be created$")
	public void an_order_will_be_created() throws Throwable {

		String OrderID = Suports.keyValueReturn(response, "id");
		Assert.assertNotNull(OrderID);

		ExternalData.WriteDataOrder(OrderID);
	}
}