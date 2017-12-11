package moip.models;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class PaymentJson {
	static String jsonResponse;

	public static String createPayment() {
		try {

			JsonObject orderObject = Json.createObjectBuilder()
					.add("fundingInstrument",
							Json.createObjectBuilder().add("method", "BOLETO").add("creditCard",
									Json.createObjectBuilder().add("expirationMonth", 12).add("expirationYear", 2020)
											.add("holder", Json.createObjectBuilder()
													.add("fullname", "Daniel dos Santos").add("birthdate", "1991-07-17")
													.add("taxDocument",
															Json.createObjectBuilder().add("type", "CPF")
																	.add("number", "40498762254").build())
													.build()))
									.add("boleto",
											Json.createObjectBuilder().add("expirationDate", "2017-12-20").build()))
					.build();

			System.out.println("Object sent: " + orderObject);

			StringWriter stringWriter = new StringWriter();
			JsonWriter writer = Json.createWriter(stringWriter);
			writer.write(orderObject);
			writer.close();
			jsonResponse = stringWriter.getBuffer().toString();

		} catch (Exception e) {
			System.out.println("Failed in sent the order.");
		}

		return jsonResponse;
	}
}