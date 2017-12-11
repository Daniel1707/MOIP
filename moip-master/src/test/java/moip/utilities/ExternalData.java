package moip.utilities;

import java.io.IOException;
import java.io.PrintWriter;

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

}