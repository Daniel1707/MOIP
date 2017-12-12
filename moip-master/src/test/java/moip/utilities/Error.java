package moip.utilities;

import java.io.IOException;
import java.io.PrintWriter;

public class Error {
	
	private static final String ERROR = "C:\\MOIP\\Error.txt";
	
	public static void write(DataError error){
			try {

				PrintWriter writer = new PrintWriter(ERROR, "UTF-8");
				writer.println("Error number: " + error.getCode());
				writer.println("Error endpoint: " + error.getEndPoint());
				
				if(error.getjSonSent().isEmpty()){
					writer.println("Error method: GET");
				}else{
					writer.println("Error json sent: " + error.getjSonSent());
				}
				
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}