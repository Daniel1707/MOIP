package moip.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ExternalData {

	private static final String FILENAME = "C:\\MOIP\\data.txt";

	public static void WriteDataCustomer(String id, String name, String email) {

		try {

			PrintWriter writer = new PrintWriter(FILENAME, "UTF-8");
			writer.println("ID: " + id);
			writer.println("NAME: " + name);
			writer.println("EMAIL: " + email);
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static Map<String, String> readDataCustomer() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		Map<String, String> dataMap = new HashMap<String, String>();

		try {

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {

				String key = line.substring(0, line.indexOf(":")).trim();
				String value = line.substring(line.indexOf(":"), line.length()).replaceAll(":", "").trim();

				dataMap.put(key, value);

				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
		} finally {
			br.close();
		}

		return dataMap;

	}

}