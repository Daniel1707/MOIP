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
	public static String response;
	String jsonRequestCustomer;
	String responseGet;

	@Given("^i want to create a new client$")
	public void i_want_to_create_a_new_client() throws Throwable {
		jsonRequestCustomer = CustomerJson.jsonObjectCustomer();
	}

	@When("^i fill all the required fields$")
	public void i_fill_all_the_required_fields() throws Throwable {
		response = Requests.post("/v2/customers", jsonRequestCustomer);
	}

	@Then("^the client will be created$")
	public void the_client_will_be_created() throws Throwable {

		Assert.assertNotNull(Suports.keyValueReturn(response, "id"));
		idClient = Suports.keyValueReturn(response, "id");

		String id = Suports.keyValueReturn(response, "id");
		String name = Suports.keyValueReturn(response, "fullname");
		String email = Suports.keyValueReturn(response, "email");

		// Write id, name and email to use in another test case
		ExternalData.WriteDataCustomer(id, name, email);
	}

	@Given("^i want to see a client that i created$")
	public void i_want_to_see_a_client_that_i_created() throws Throwable {

	}

	@When("^i call the service to show the clients$")
	public void i_fill_te_client_s_number() throws Throwable {
		responseGet = Requests.get("/v2/customers/" + idClient);
	}

	@Then("^the client will be show$")
	public void the_client_will_be_show() throws Throwable {
		Assert.assertNotNull(Suports.keyValueReturn(responseGet, "id"));

		String nome = Suports.keyValueReturn(responseGet, "fullname");
		Assert.assertEquals("Daniel dos Santos", nome);

		String id = Suports.keyValueReturn(responseGet, "id");
		Assert.assertEquals(idClient, id);
	}
}