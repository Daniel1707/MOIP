package moip.stepsJava;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.PaymentJson;
import moip.utilities.ExternalData;
import moip.utilities.Requests;
import moip.utilities.Suports;

public class Payment {

	String jsonRequestOrder;
	String response;

	Map<String, String> dataMap = new HashMap<String, String>();

	@Given("^i want to create a payment$")
	public void i_want_to_create_a_payment() throws Throwable {
		jsonRequestOrder = PaymentJson.createPayment();
	}

	@When("^i fill the field order_id and all the required fields$")
	public void i_fill_the_field_order_id_and_all_the_required_fields() throws Throwable {

		dataMap = ExternalData.readDataOrder();
		response = Requests.post("/v2/orders/" + dataMap.get("OrderID") + "/payments", jsonRequestOrder);
	}

	@Then("^the payment will be sent$")
	public void the_payment_will_be_sent() throws Throwable {
		Assert.assertNotNull(Suports.keyValueReturn(response, "status"));
		Assert.assertEquals(Suports.keyValueReturn(response, "status"), "IN_ANALYSIS");
	}
}
