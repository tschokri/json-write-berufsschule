package de.layla.berufsschule.Auftrag1c;

/* Auftrag 1c) Erstellen Sie folgende book1c.json:
{
	"titel": "XQuery Kick Start",
	"verlag": {
		"name": "Sams",
		"ort": "Indianapolis"
	},
	"autoren": [
		"James McGovern",
		"Per Bothner",
		"Kurt Cagle",
		"James Linn"
	]
}
*/

import java.io.FileWriter;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class WriteBookDataJason {

	public static void main(String[] args) {

		ArrayList<String> autorenliste = new ArrayList<String>();
		autorenliste.add("James McGovern");
		autorenliste.add("Per Bothner");
		autorenliste.add("Kurt Cagle");
		autorenliste.add("James Linn");

		Verlag verlag = new Verlag("Sams", "Indianapolis");

		Buch buch = new Buch("XQuery Kick Start", autorenliste, verlag);

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("titel", buch.getTitel());

		JsonObjectBuilder verlagJson = Json.createObjectBuilder();
		verlagJson.add("name", buch.getVerlag().getName());
		verlagJson.add("ort", buch.getVerlag().getOrt());

		builder.add("verlag", verlagJson);

		JsonArrayBuilder autorArray = Json.createArrayBuilder();
		for (String autor : buch.getAutorenliste()) {
			autorArray.add(autor);
		}
		builder.add("autoren", autorArray);

		JsonObject jo = builder.build();

		try {
			FileWriter fw = new FileWriter("book1c.json");
			JsonWriter jw = Json.createWriter(fw);
			jw.write(jo);
			fw.close();
			jw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
