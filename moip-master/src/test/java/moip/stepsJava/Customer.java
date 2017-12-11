package moip.stepsJava;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moip.models.CustomerJson;
import moip.utilities.Requests;
import moip.utilities.Suports;

public class Customer {

	public static String idClient;

	@Given("^i want to create a new client$")
	public void i_want_to_create_a_new_client() throws Throwable {
	}

	@When("^i fill all the required fields$")
	public void i_fill_all_the_required_fields() throws Throwable {
		String jsonRequestCustomer = CustomerJson.jsonObjectCustomer();
		String response = Requests.post("/v2/customers", jsonRequestCustomer);

		System.out.println(Suports.keyValueReturn(response, "id"));
		Assert.assertNotNull(Suports.keyValueReturn(response, "id"));

		idClient = Suports.keyValueReturn(response, "id");
	}

	@Then("^the client will be created$")
	public void the_client_will_be_created() throws Throwable {
	}

	@Given("^i want to see a client that i created$")
	public void i_want_to_see_a_client_that_i_created() throws Throwable {
	}

	@When("^i call the service to show the clients$")
	public void i_fill_te_client_s_number() throws Throwable {

		String response = Requests.get("/v2/customers/" + idClient);
		
		System.out.println(Suports.keyValueReturn(response, "id"));
		Assert.assertNotNull(Suports.keyValueReturn(response, "id"));
		
		String nome = Suports.keyValueReturn(response, "fullname");
		
		System.out.println(nome);
		
		Assert.assertEquals("Daniel dos Santos", nome);
	}

	@Then("^the client will be show$")
	public void the_client_will_be_show() throws Throwable {

	}
}