package moip.models;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import moip.utilities.Suports;

public class OrderJson {

	static String jsonResponse;

	public static String create() {

		try {

			JsonObject orderObject = Json.createObjectBuilder().add("ownId", Suports.randomIdCustomer())

					.add("amount", Json.createObjectBuilder().add("currency", "BRL")
							.add("subtotals", Json.createObjectBuilder().add("shipping", "1000")).build())

					.add("items",
							Json.createArrayBuilder()
									.add(Json.createObjectBuilder().add("product", "Description")
											.add("category", "CLOTHING").add("quantity", "1").add("detail", "detail")
											.add("price", "1000").build())
									.build())

					.add("customer", Json.createObjectBuilder().add("ownId", "CUS").build())

					//.add("receivers",
					//		Json.createArrayBuilder()
					//				.add(Json.createObjectBuilder().add("type", "SECONDARY").add("feePayor", "true"))
					//				.add("moipAccount", Json.createObjectBuilder().add("id", "MPA-E3C8493A06AE"))
					//				.add("amount", Json.createObjectBuilder().add("id", "MPA-E3C8493A06AE").build())

									.build();

			StringWriter stringWriter = new StringWriter();
			JsonWriter writer = Json.createWriter(stringWriter);
			writer.write(orderObject);
			writer.close();
			jsonResponse = stringWriter.getBuffer().toString();

			System.out.println("ORDER JSON: " + jsonResponse);

		} catch (Exception e) {
			System.out.println("Failed in send the order.");
		}

		return jsonResponse;
	}
}