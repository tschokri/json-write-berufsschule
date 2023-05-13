package de.layla.berufsschule.Auftrag4;

import java.io.FileWriter;
import java.io.IOException;

/* Auftrag 4) Erstellen Sie notwendige Klassen und erstellen Sie folgende buchhandlung4.json:
{
	"name": "OSZIMT Buchhandlung",
	"tel": "030-225027-800",
	"fax": "030-225027-809",
	"adresse": {
		"strasse": "Haarlemer Straße",
		"hausnummer": "23-27",
		"plz": "12359",
		"ort": "Berlin"
	},
	"buchliste": [
		{
			"titel": "Java ist auch eine Insel",
			"jahr": 1998,
			"preis": 49.9,
			"autor": "Christian Ullenboom"
		},
		{
			"titel": "SQL: Handbuch für Einsteiger",
			"jahr": 2020,
			"preis": 17.99,
			"autor": "Paul Fuchs"
		},
		{
			"titel": "PHP und MySQL für einsteiger",
			"jahr": 2018,
			"preis": 9.99,
			"autor": "Michael Bonacina"
		},
		{
			"titel": "Einführung in SQL",
			"jahr": 2021,
			"preis": 29.9,
			"autor": "Alan Beaulieu"
		},
		{
			"titel": "Java Programmieren für Einsteiger",
			"jahr": 2020,
			"preis": 13.95,
			"autor": "Simon Flaig"
		},
		{
			"titel": "Git Handbuch für Einsteiger",
			"jahr": 2021,
			"preis": 19.99,
			"autor": "Paul Fuchs"
		},
		{
			"titel": "Captain CiaoCiao erobert Java",
			"jahr": 2021,
			"preis": 39.9,
			"autor": "Paul Fuchs"
		},
		{
			"titel": "Java: Kompendium: Professionell Java programmieren lernen",
			"jahr": 2019,
			"preis": 19.99,
			"autor": "Markus Neumann"
		},
		{
			"titel": "Python Crash Course, 2nd Edition",
			"jahr": 2019,
			"preis": 25.99,
			"autor": "Eric Matthes"
		}
	]
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

public class WriteBookstoreDataJason {

	public static void main(String[] args) {

		ArrayList<Buch> buchliste = new ArrayList<Buch>();
		buchliste.add(new Buch("Java ist auch eine Insel", 1998, 49.90, "Christian Ullenboom"));
		buchliste.add(new Buch("SQL: Handbuch für Einsteiger", 2020, 17.99, "Paul Fuchs"));
		buchliste.add(new Buch("PHP und MySQL für einsteiger", 2018, 9.99, "Michael Bonacina"));
		buchliste.add(new Buch("Einführung in SQL", 2021, 29.90, "Alan Beaulieu"));
		buchliste.add(new Buch("Java Programmieren für Einsteiger", 2020, 13.95, "Simon Flaig"));
		buchliste.add(new Buch("Git Handbuch für Einsteiger", 2021, 19.99, "Paul Fuchs"));
		buchliste.add(new Buch("Captain CiaoCiao erobert Java", 2021, 39.90, "Paul Fuchs"));
		buchliste.add(
				new Buch("Java: Kompendium: Professionell Java programmieren lernen", 2019, 19.99, "Markus Neumann"));
		buchliste.add(new Buch("Python Crash Course, 2nd Edition", 2019, 25.99, "Eric Matthes"));

		JsonArrayBuilder booksObject = Json.createArrayBuilder();
		for (Buch buch : buchliste) {
			booksObject.add(Json.createObjectBuilder()
					.add("titel", buch.getTitel())
					.add("jahr", buch.getJahr())
					.add("preis", buch.getPreis())
					.add("autor", buch.getAutor()));
		}

		Buchhandlung buchhandlung = new Buchhandlung("OSZIMT Buchhandlung", "030-225027-800", "030-225027-809",
				new Adresse("Haarlemer Straße", "23-27", "12359", "Berlin"), buchliste);

		JsonObject buchhandlungJsonObject = Json.createObjectBuilder()
		.add("name", buchhandlung.getName())
		.add("tel", buchhandlung.getTel())
		.add("fax", buchhandlung.getFax())
		.add("adresse", Json.createObjectBuilder()
				.add("strasse", buchhandlung.getAdresse().getStrasse())
				.add("hausnummer", buchhandlung.getAdresse().getHausnummer())
				.add("plz", buchhandlung.getAdresse().getPlz())
				.add("ort", buchhandlung.getAdresse().getOrt()))
		.add("buchliste", booksObject)
		.build();

		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonWriterFactory factory = Json.createWriterFactory(config);

		try {
			FileWriter fileWriter = new FileWriter("bookstore.json");
			JsonWriter jsonWriter = factory.createWriter(fileWriter);
			jsonWriter.write(buchhandlungJsonObject);
			fileWriter.close();
			jsonWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
