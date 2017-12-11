package moip.utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Requests {
	public static String post(String endPoint, String json) throws IOException {

		StringEntity entity = new StringEntity(json, ContentType.APPLICATION_FORM_URLENCODED);

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost request = new HttpPost("https://sandbox.moip.com.br" + endPoint);
		request.setEntity(entity);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		request.setHeader("Authorization",
				"Basic MllVRDdEUUhCODVJSDhIRDY3R1dEUVpTRU5VSlVWQU46RVlWVUVKWVU3TVhRTVlOTzdQOFNVTEEzSEVRWlhOM01RWUJFVUJUUQ==");

		HttpResponse response = httpClient.execute(request);
		System.out.println(response.getStatusLine().getStatusCode());
		String responseBody = EntityUtils.toString(response.getEntity());
		
		System.out.println("RESPOSTA DO SISTEMA: " + responseBody);

		return responseBody;
	}

	public static String get(String endPoint) throws IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet("https://sandbox.moip.com.br" + endPoint);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		request.setHeader("Authorization",
				"Basic MllVRDdEUUhCODVJSDhIRDY3R1dEUVpTRU5VSlVWQU46RVlWVUVKWVU3TVhRTVlOTzdQOFNVTEEzSEVRWlhOM01RWUJFVUJUUQ==");

		HttpResponse response = httpClient.execute(request);
		System.out.println(response.getStatusLine().getStatusCode());
		String responseBody = EntityUtils.toString(response.getEntity());
		return responseBody;
	}
}
