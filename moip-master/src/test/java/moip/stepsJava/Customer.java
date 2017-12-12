package moip.stepsJava;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.CustomerJson;
import moip.utilities.ExternalData;
import moip.utilities.Requests;
import moip.utilities.Suports;

public class Customer {

	public static String idClient;
	public static String responseCreateCustomer;
	String jsonRequestCustomer;
	String responseGet;

	String responseAssociateCreditCard;
	String jsonRequestCreditCard;

	// Create client
	@Given("^i want to create a new client$")
	public void i_want_to_create_a_new_client() throws Throwable {
		jsonRequestCustomer = CustomerJson.jsonObjectCustomer();
	}

	@When("^i fill all the required fields$")
	public void i_fill_all_the_required_fields() throws Throwable {
		responseCreateCustomer = Requests.post("/v2/customers", jsonRequestCustomer);
	}

	@Then("^the client will be created$")
	public void the_client_will_be_created() throws Throwable {

		Assert.assertNotNull(Suports.keyValueReturn(responseCreateCustomer, "id"));
		idClient = Suports.keyValueReturn(responseCreateCustomer, "id");

		String id = Suports.keyValueReturn(responseCreateCustomer, "id");
		String name = Suports.keyValueReturn(responseCreateCustomer, "fullname");
		String email = Suports.keyValueReturn(responseCreateCustomer, "email");

		// Write id, name and email to use in another test case
		ExternalData.WriteDataCustomer(id, name, email);
	}

	// Show client
	@Given("^i want to see a client that i created$")
	public void i_want_to_see_a_client_that_i_created() throws Throwable {

	}

	@When("^i call the service to show the client$")
	public void i_fill_te_client_s_number() throws Throwable {
		responseGet = Requests.get("/v2/customers/" + idClient);
	}

	@Then("^the client will be show$")
	public void the_client_will_be_show() throws Throwable {
		Assert.assertNotNull(Suports.keyValueReturn(responseGet, "id"));

		String id = Suports.keyValueReturn(responseGet, "id");
		Assert.assertEquals(idClient, id);
	}

	// Associate credit Card
	@Given("^i want to add a credit card to client that i created$")
	public void i_want_to_add_a_credit_card_to_client_that_i_created() throws Throwable {
		jsonRequestCreditCard = CustomerJson.jsonObjectCreditCard();
	}

	@When("^i call the service client filling all the required fields$")
	public void i_call_the_service_client_filling_all_the_required_fields() throws Throwable {
		responseAssociateCreditCard = Requests.post("/v2/customers/" + idClient + "/fundinginstruments",
				jsonRequestCreditCard);
	}

	@Then("^the credit card will be associated to the client$")
	public void the_credit_card_will_be_associated_to_the_client() throws Throwable {
		Assert.assertNotNull(Suports.keyValueReturn(responseAssociateCreditCard, "id", "creditCard"));
	}
}