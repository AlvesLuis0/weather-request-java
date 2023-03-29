import javax.json.JsonObject;

public class Weather {
	String city;
	String country;
	String main;
	String description;
	float temp;
	float tempMin;
	float tempMax;

	// função que cria o nosso objeto
	Weather(JsonObject object) {
		this.city = object.getString("name");
		this.country = object.getJsonObject("sys").getString("country");
		this.main = object.getJsonArray("weather").get(0).asJsonObject().getString("main");
		this.description = object.getJsonArray("weather").get(0).asJsonObject().getString("description");
		this.temp = object.getJsonObject("main").getJsonNumber("temp").numberValue().floatValue();
		this.tempMin = object.getJsonObject("main").getJsonNumber("temp_min").numberValue().floatValue();
		this.tempMax = object.getJsonObject("main").getJsonNumber("temp_max").numberValue().floatValue();
	}

	// função que printa seus valores
	public void print() {
		System.out.printf("City: %s\n", this.city);
		System.out.printf("Country: %s\n", this.country);
		System.out.printf("Main: %s\n", this.main);
		System.out.printf("Description: %s\n", this.description);
		System.out.printf("Temp: %.2f°C\n", this.temp);
		System.out.printf("TempMin: %.2f°C\n", this.tempMin);
		System.out.printf("TempMax: %.2f°C\n", this.tempMax);
	}
}