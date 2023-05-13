package de.layla.berufsschule.Auftrag5;

import java.io.FileWriter;
import java.io.IOException;

/* Auftrag 5) Erstellen Sie notwendige Klassen und erstellen Sie folgende buchhandlung5.json:
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
			"Autorenliste": [
				"Christian Ullenboom",
				"Paul Fuchs"
			]
		},
		{
			"titel": "XQuery Kick Start",
			"jahr": 2020,
			"preis": 17.99,
			"Autorenliste": [
				"James McGovern",
				"Per Bothner",
				"Kurt Cagle",
				"James Linn"
			]
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
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

public class WriteBookstoreDataJason {

	public static void main(String[] args) {

		ArrayList<Buch> buchliste = new ArrayList<Buch>();
		ArrayList<String> autorenliste = new ArrayList<String>();

		autorenliste.add("Christian Ullenboom");
		autorenliste.add("Paul Fuchs");
		buchliste.add(new Buch("Java ist auch eine Insel", 1998, 49.90, autorenliste));

		autorenliste = new ArrayList<String>();
		autorenliste.add("James McGovern");
		autorenliste.add("Per Bothner");
		autorenliste.add("Kurt Cagle");
		autorenliste.add("James Linn");
		buchliste.add(new Buch("XQuery Kick Start", 2020, 17.99, autorenliste));

		Buchhandlung buchhandlung = new Buchhandlung("OSZIMT Buchhandlung", "030-225027-800", "030-225027-809",
				new Adresse("Haarlemer Straße", "23-27", "12359", "Berlin"), buchliste);

		JsonArrayBuilder buchlisteBuilder = Json.createArrayBuilder();
		for (Buch buch : buchhandlung.getBuchliste()) {
			buchlisteBuilder.add(createBookJsonObject(buch, buch.getAutorenliste()));
		}
		
		JsonObject object = Json.createObjectBuilder()
			.add("name", buchhandlung.getName())
			.add("tel", buchhandlung.getTel())
			.add("fax", buchhandlung.getFax())
			.add("adresse", Json.createObjectBuilder()
			.add("adresse", createAdresseJsonObject(buchhandlung.getAdresse())))
			.add("buchliste", buchlisteBuilder)
		.build();

		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonWriterFactory factory = Json.createWriterFactory(config);

		try {
			FileWriter fileWriter = new FileWriter("bookstore.json");
			JsonWriter jsonWriter = factory.createWriter(fileWriter);
			jsonWriter.write(object);
			fileWriter.close();
			jsonWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static JsonObject createAdresseJsonObject(Adresse adresse) {
        JsonObjectBuilder adresseBuilder = Json.createObjectBuilder()
                .add("strasse", adresse.getStrasse())
                .add("hausnummer", adresse.getHausnummer())
                .add("plz", adresse.getPlz())
                .add("ort", adresse.getOrt());
        return adresseBuilder.build();
    }

    private static JsonObject createBookJsonObject(Buch book, ArrayList<String> autoren) {
        JsonArrayBuilder autorenlisteBuilder = Json.createArrayBuilder();
        for (String autor : autoren) {
            autorenlisteBuilder.add(autor);
        }

        JsonObject bookBuilder = Json.createObjectBuilder()
                .add("titel", book.getTitel())
                .add("jahr, ", book.getJahr())
                .add("preis", book.getPreis())
                .add("Autorenliste", autorenlisteBuilder)
				.build();
        return bookBuilder;
    }

}
