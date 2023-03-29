import java.util.Locale;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		// setando configurações iniciais
		Locale.setDefault(Locale.US);

		// declarando variáveis
		String city;
		String apiKey = "a064781f48c41b68062dde044abf4d83";
		String url;
		var scanner = new Scanner(System.in);

		// requisitando informações ao usuário
		System.out.print("Enter the name of a city:\n>> ");
		city = scanner.next();
		scanner.close();
		System.out.println();

		// pedindo uma resposta à URL
		url = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s".formatted(city, apiKey);
		String response = Requests.get(url);
		var json = Requests.parse(response);
		var weather = new Weather(json);
		weather.print();
	}
}