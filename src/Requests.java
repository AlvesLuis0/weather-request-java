import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import javax.json.Json;
import javax.json.JsonObject;

public class Requests {
	// função que faz uma requisição à uma URL
	public static String get(String url) throws Exception {
		var address = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(address).GET().build();
		var response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		return body;
	}

	// função que "parsea" a string
	public static JsonObject parse(String jsonString) {
		var reader = Json.createReader(new StringReader(jsonString));
		var jsonObject = reader.readObject();
		return jsonObject;
	}
}