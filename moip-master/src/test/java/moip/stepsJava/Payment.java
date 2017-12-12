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
import moip.utilities.ExternalData.TipoArquivo;

public class Payment {

	String jsonRequestOrder;
	String response;

	Map<String, String> orderData = new HashMap<String, String>();
	Map<String, String> paymentPreviousCreated = new HashMap<String, String>();

	// CREATE PAYMENT

	@Given("^i want to create a payment$")
	public void i_want_to_create_a_payment() throws Throwable {
		jsonRequestOrder = PaymentJson.createPayment();
	}

	@When("^i fill the field order_id and all the required fields$")
	public void i_fill_the_field_order_id_and_all_the_required_fields() throws Throwable {
		orderData = ExternalData.read(TipoArquivo.ORDER);
		response = Requests.post("/v2/orders/" + orderData.get("OrderID") + "/payments", jsonRequestOrder);
	}

	@Then("^the payment will be sent$")
	public void the_payment_will_be_sent() throws Throwable {
		Assert.assertNotNull(Suports.keyValueReturn(response, "id"));
		Assert.assertEquals("WAITING", Suports.keyValueReturn(response, "status"));

		ExternalData.WriteDataPayment(Suports.keyValueReturn(response, "id"));
	}

	// SHOW PAYMENT
	@Given("^i want to see a payment$")
	public void i_want_to_see_a_payment() throws Throwable {
		paymentPreviousCreated = ExternalData.read(TipoArquivo.PAYMENT);
	}

	@When("^i fill the field payment_id$")
	public void i_fill_the_field_payment_id() throws Throwable {

	}

	@Then("^the payment will be show$")
	public void the_payment_will_be_show() throws Throwable {

	}
}
