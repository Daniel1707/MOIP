package moip.stepsJava;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.OrderJson;
import moip.utilities.ExternalData;
import moip.utilities.Requests;
import moip.utilities.Suports;
import moip.utilities.ExternalData.TipoArquivo;

public class Order {

	String jsonRequestOrder;
	String responseCreateOrder;
	
	String responseShowOrder;

	//CREATE ORDER
	@Given("^i want to create an order$")
	public void i_want_an_order() throws Throwable {
		jsonRequestOrder = OrderJson.createOrderAsExistingUser();
	}

	@When("^i fill all required fields and associate a client to order$")
	public void i_fill_all_required_fields_and_associate_a_client_to_order() throws Throwable {
		responseCreateOrder = Requests.post("/v2/orders", jsonRequestOrder);
	}

	@Then("^an order will be created$")
	public void an_order_will_be_created() throws Throwable {

		String orderID = Suports.keyValueReturn(responseCreateOrder, "id");
		Assert.assertNotNull(orderID);

		ExternalData.WriteDataOrder(orderID);
	}
	
	Map<String, String> orderPreviousCreated = new HashMap<String, String>();
	
	//SHOW ORDER
	@Given("^i want to show an order$")
	public void i_want_to_show_an_order() throws Throwable {
		orderPreviousCreated = ExternalData.read(TipoArquivo.ORDER);
	}

	@When("^i fill the order_id$")
	public void i_fill_the_order_id() throws Throwable {
		responseShowOrder = Requests.get("/v2/orders/" + orderPreviousCreated.get("OrderID"));
	}

	@Then("^the order will be show$")
	public void the_order_will_be_show() throws Throwable {
		String orderID = Suports.keyValueReturn(responseShowOrder, "id");
		Assert.assertEquals(orderPreviousCreated.get("OrderID"), orderID);
	}
}