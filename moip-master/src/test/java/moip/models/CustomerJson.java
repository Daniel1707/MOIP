package moip.models;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import moip.utilities.Suports;

public class CustomerJson {

	public static String jsonObjectCustomer() {

		String jsonResponse = null;

		try {

			JsonObject custumerObject = Json.createObjectBuilder().add("ownId", Suports.randomIdCustomer())
					.add("fullname", "Daniel dos Santos").add("email", "daniel@yahoo.com.br")
					.add("birthDate", "1988-12-30")
					.add("taxDocument",
							Json.createObjectBuilder().add("type", "CPF").add("number", "22222222222").build())
					.add("phone",
							Json.createObjectBuilder().add("countryCode", "55").add("areaCode", "11")
									.add("number", "99882233").build())
					.add("shippingAddress",
							Json.createObjectBuilder().add("city", "Sao Paulo").add("complement", "8")
									.add("district", "Itaim").add("street", "Avenida Faria Lima")
									.add("streetNumber", "2927").add("zipCode", "01234000").add("state", "SP")
									.add("state", "SP").add("country", "BRA").build())
					.build();

			StringWriter stringWriter = new StringWriter();
			JsonWriter writer = Json.createWriter(stringWriter);
			writer.write(custumerObject);
			writer.close();
			jsonResponse = stringWriter.getBuffer().toString();

		} catch (Exception e) {
			System.out.println("Failed in send the customer.");
		}

		return jsonResponse;
	}

	public static String jsonObjectCreditCard() {

		String jsonResponse = null;

		try {

			JsonObject custumerObject = Json.createObjectBuilder().add("method", "CREDIT_CARD")
					.add("creditCard", Json.createObjectBuilder().add("expirationMonth", "05")
							.add("expirationYear", "22").add("number", "5555666677778884").add("cvc", "123").add(
									"holder",
									Json.createObjectBuilder().add("fullname", "teste").add("birthdate", "123")
											.add("taxDocument",
													Json.createObjectBuilder().add("CPF", "123").add("number", "123")
															.build())
											.add("phone",
													Json.createObjectBuilder().add("countryCode", "123")
															.add("areaCode", "123").add("number", "123").build())
											.build())
							.build())

					.build();

			StringWriter stringWriter = new StringWriter();
			JsonWriter writer = Json.createWriter(stringWriter);
			writer.write(custumerObject);
			writer.close();
			jsonResponse = stringWriter.getBuffer().toString();

			System.out.println("________--------------------CREDIT CARD - " + jsonResponse);

		} catch (Exception e) {
			System.out.println("Failed in send the credit card.");
		}

		return jsonResponse;
	}
}
