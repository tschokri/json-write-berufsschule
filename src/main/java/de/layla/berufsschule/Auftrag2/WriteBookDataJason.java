package de.layla.berufsschule.Auftrag2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/* Auftrag 2) Erstellen Sie folgende book2.json:
{
	"titel": "Java ist auch eine Insel",
	"jahr": 1998,
	"preis": 29.95,
	"autor": "Christian Ullenboom"
}
*/
public class WriteBookDataJason {

	public static void main(String[] args) {

		Buch b1 = new Buch("Java ist auch eine Insel", 1998, 29.95, "Christian Ullenboom");

		JsonObject object = Json.createObjectBuilder()
		.add("titel", b1.getTitel())
		.add("jahr", b1.getJahr())
		.add("preis", b1.getPreis())
		.add("autor", b1.getAutor())
		.build();

		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonWriterFactory factory = Json.createWriterFactory(config);

		try {
			FileWriter fileWriter = new FileWriter("book2.json");
			JsonWriter jsonWriter = factory.createWriter(fileWriter);
			jsonWriter.write(object);
			fileWriter.close();
			jsonWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
