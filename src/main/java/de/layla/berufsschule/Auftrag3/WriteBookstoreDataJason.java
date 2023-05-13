package de.layla.berufsschule.Auftrag3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/* Auftrag 3) Erstellen Sie notwendige Klassen und erstellen Sie folgende buchhandlung3.json:
{
	"name": "OSZIMT Buchhandlung",
	"tel": "030-225027-800",
	"fax": "030-225027-809",
	"adresse": {
		"strasse": "Haarlemer Strasse",
		"hausnummer": "23-27",
		"plz": "12359",
		"ort": "Berlin"
	}
}

*/

public class WriteBookstoreDataJason {

	public static void main(String[] args) {
		
		Adresse adresse = new Adresse("Haarlemer Strasse", "23-27", "12359", "Berlin");
		Buchhandlung buchhandlung = new Buchhandlung("OSZIMT Buchhandlung", "030-225027-800", "030-225027-809",  adresse);

		JsonObject adresseJsonObject = Json.createObjectBuilder()
		.add("strasse", adresse.getStrasse())
		.add("hausnummer", adresse.getHausnummer())
		.add("plz", adresse.getPlz())
		.add("ort", adresse.getOrt())
		.build();

		JsonObject buchhandJsonObject = Json.createObjectBuilder()
		.add("Name", buchhandlung.getAdresse().getStrasse())
		.add("tel", buchhandlung.getTel())
		.add("fax", buchhandlung.getFax())
		.add("adresse", adresseJsonObject)
		.build();

		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonWriterFactory factory = Json.createWriterFactory(config);

		try {
			FileWriter fileWriter = new FileWriter("bookstore.json");
			JsonWriter jsonWriter = factory.createWriter(fileWriter);
			jsonWriter.write(buchhandJsonObject);
			fileWriter.close();
			jsonWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
