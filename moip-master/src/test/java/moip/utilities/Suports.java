package moip.utilities;

import java.util.UUID;

import org.json.JSONObject;

public class Suports {
	public static String randomIdCustomer() {

		String uuid = null;

		try {
			uuid = UUID.randomUUID().toString();
			return uuid;
		} catch (Exception e) {
			System.out.println("Failed in create an random id. See method randomIdCustomer");
		}

		return uuid;

	}
	
	public static String keyValueReturn(String jsonResponse, String keyValue) {

		JSONObject jsonObj = new JSONObject(jsonResponse);
		String value = jsonObj.getString(keyValue);
		return value;

	}
	
}