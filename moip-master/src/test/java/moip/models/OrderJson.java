package moip.models;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import moip.utilities.ExternalData;
import moip.utilities.Suports;
import moip.utilities.ExternalData.TipoArquivo;

public class OrderJson {

	static String jsonResponse;

	public static String createOrderAsExistingUser() {

		Map<String, String> dataMap = new HashMap<String, String>();

		try {
			dataMap = ExternalData.read(TipoArquivo.CUSTOMER);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		String userID = dataMap.get("ID");
		String userName = dataMap.get("NAME");
		String userEmail = dataMap.get("EMAIL");

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

					.add("customer", Json.createObjectBuilder().add("ownId", userID).add("fullname", userName)
							.add("email", userEmail).build())

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